import { useEffect, useState } from 'react';
import AuthService from '../../services/AuthService';
import UserService from '../../services/UserService';
import PurchaseRecordService from '../../services/PurchaseRecordService';
import ReviewService from '../../services/ReviewService';

import CourseCard from '../../components/CourseCard';
import Review from '../../components/Review';

import { BsImageFill } from 'react-icons/bs';

const AccountPage = () => {

    const [user, setUser] = useState({});

    const [reviews, setReviews] = useState([]);
    const [purchasedCourses, setPurchasedCourses] = useState([]);

    const [selectedFile, setSelectedFile] = useState(null);

    const [selectedError, setSelectedError] = useState(false);
    const [sizeError, setSizeError] = useState(false);

    useEffect(
        () => {
            setUser(AuthService.getCurrentUser());

            PurchaseRecordService.getAllByUsername(AuthService.getCurrentUser().username).then(response => {
                setPurchasedCourses(response.data);
            });

            ReviewService.getAllByUsername(AuthService.getCurrentUser().username).then(response => {
                setReviews(response.data);
            });
        },
        []
    );

    const fileSelectedHandler = (event) => {
        setSelectedFile(event.target.files[0]);

        if (event.target.files[0]) {
            const newAvatar = document.getElementById('newAvatar');
            newAvatar.src = URL.createObjectURL(event.target.files[0]);

            document.getElementById('imagePreview').style.display = 'block';
        }
    }

    const fileUploadHandler = (event) => {
        event.preventDefault();

        if (!selectedFile) {
            setSelectedError(true);
            return;
        }

        const fileSize = selectedFile.size;

        if (fileSize > 1048576) {
            setSizeError(true);
            return;
        }

        const formData = new FormData();
        formData.append('file', selectedFile);

        UserService.uploadAvatar(AuthService.getCurrentUser().username, formData).then(response => {
            AuthService.setCurrentUser(response.data);
            window.location.reload();
        });
    }

    return (
        <div className="cm-account">
            <div className="cm-account__container">
                <div className="cm-account__left">
                    <img
                        src={user.avatar}
                        alt={user.username}
                        className="cm-account__img"
                        height="200"
                        width="200"
                    />
                    <form className="cm-account__form" onSubmit={(e) => fileUploadHandler(e)}>
                        <label htmlFor="uploadAvatar">
                            <div className="cm-account__upload-text">
                                <BsImageFill style={{ marginRight: '.5rem' }} />
                                <p>Upload image</p>
                            </div>
                            <input id="uploadAvatar" type="file" className="cm-account__upload-file" accept="image/*" onChange={(e) => fileSelectedHandler(e)} />
                        </label>
                        <div id="imagePreview" className="cm-account__image-preview-container">
                            <p className="cm-account__image-preview-heading">Image preview:</p>
                            <div className="cm-account__image-preview">
                                <img alt="New avatar" id="newAvatar" className="cm-account__new-image" />
                            </div>
                        </div>
                        <button type="submit" className="cm-btn">Change avatar</button>
                        {selectedError && (
                            <div className="cm-account__error">
                                You must select an image.
                            </div>
                        )}
                        {sizeError && (
                            <div className="cm-account__error">
                                Image size can not be larger than 1MB.
                            </div>
                        )}
                    </form>
                </div>

                <div className="cm-account__right">
                    <div className="cm-account__content">
                        <h1 className="cm-account__name">{user.firstName} {user.lastName}</h1>
                        <p className="cm-account__email">@{user.username}</p>
                        <br />
                        <p className="cm-account__email">Email adress: {user.email}</p>
                        <p className="cm-account__reg-date">Registration date: <b> {user.dateCreated} </b></p>
                        <p className="cm-account__email">Proffesion: {user.profession}</p>
                        <h3 className="cm-account__heading">Purchased courses ({purchasedCourses.length}):</h3>
                        <div className="cm-account__course-list">
                            {purchasedCourses.map(courseDto => (
                                <CourseCard
                                key={courseDto.course.id}
                                id={courseDto.course.id}
                                name={courseDto.course.name}
                                picture={courseDto.course.picture}
                                price={courseDto.course.price}
                                averageRating={courseDto.averageRating}
                                numberOfRatings={courseDto.numberOfRatings}
                                authorUsername={courseDto.author.username}
                                authorFirstName={courseDto.author.firstName}
                                authorLastName={courseDto.author.lastName}
                                numberOfStudents={courseDto.numberOfStudents}
                                />
                            ))}
                        </div>
                        <h3 className="cm-account__heading">Your reviews ({reviews.length}):</h3>
                        <ul className="cm-account__review-list">
                            {reviews.map(review => (
                                <Review
                                key={review.id}
                                review={review}
                                />
                            ))}
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    );
}

export default AccountPage;