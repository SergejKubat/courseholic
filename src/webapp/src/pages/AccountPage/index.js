import { useEffect, useState } from 'react';
import AuthService from '../../services/AuthService';
import PurchaseRecordService from '../../services/PurchaseRecordService';
import ReviewService from '../../services/ReviewService';

import CourseCard from '../../components/CourseCard';
import Review from '../../components/Review';

const AccountPage = () => {

    const [user, setUser] = useState({});

    const [reviews, setReviews] = useState([]);
    const [purchasedCourses, setPurchasedCourses] = useState([]);

    const [selectedFile, setSelectedFile] = useState(null);

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
    }

    const fileUploadHandler = (event) => {
        event.preventDefault();

        const formData = new FormData();
        formData.append('avatar', selectedFile, selectedFile.name);
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
                        <button className="cm-btn">Upload picture</button>
                        <input type="file" className="cm-account__upload-file" onChange={(e) => fileSelectedHandler(e)} />
                        {/*<div className="cm-account__image-preview">
                            <img alt="Nova slika" className="cm-account__new-image" />
                        </div>
                        <div className="cm-account__error">
                            You must upload picture (allowed formats: .jpg, .jpeg ili .png)
                            </div>
                        <button className="cm-btn" type="submit">Change avatar</button>*/}
                    </form>
                </div>

                <div className="cm-account__right">
                    <div className="cm-account__content">
                        <h1 className="cm-account__name">{user.firstName} {user.lastName}</h1>
                        <p className="cm-account__email">@{user.username}</p>
                        <p className="cm-account__email">{user.email}</p>
                        <p className="cm-account__reg-date">Registration date: <b> {user.dateCreated} </b></p>
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
                                numberOfRating={courseDto.numberOfRating}
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