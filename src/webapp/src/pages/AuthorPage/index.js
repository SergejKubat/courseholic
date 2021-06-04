import { useEffect, useState } from "react";
import { useParams } from "react-router";

import AuthorService from '../../services/AuthorService';

import CourseCard from '../../components/CourseCard';

const AuthorPage = () => {

    const params = useParams();

    const [authorDto, setAuthorDto] = useState({ 
        author: {}, 
        courses: [] 
    });

    useEffect(
        () => {
            AuthorService.getByUsername(params.username).then(response => {
                setAuthorDto(response.data);
            });
        },
        []
    );

    return (
        <section className="cm-author">
            <div className="cm-author__container">
                <img src={authorDto.author.avatar} alt={authorDto.author.username} className="cm-author__img" height="200" width="200" />
                <div className="cm-author__content">
                    <div className="cm-author__title">Author</div>
                    <h1 className="cm-author__heading">{authorDto.author.firstName} {authorDto.author.lastName}</h1>
                    <h2 className="cm-author__job">{authorDto.author.proffesion}</h2>
                    <div className="cm-author__stats">
                    <div className="cm-author__stat">
                        <div className="cm-author__stat-title">Students</div>
                        <div className="cm-author__stat-count">{authorDto.numberOfStudents}</div>
                    </div>
                    <div className="cm-author__stat">
                        <div className="cm-author__stat-title">Reviews</div>
                        <div className="cm-author__stat-count">{authorDto.numberOfRatings}</div>
                    </div>
                    </div>
                    <h2 className="cm-author__about-heading">About me</h2>
                    <p className="cm-author__about-text">{authorDto.author.description}</p>
                </div>

                <div className="cm-author__courses">
                    <h2 className="cm-author__courses-title">My courses ({authorDto.courses.length})</h2>
                    <div className="cm-author__courses-list">
                        {authorDto.courses.map(courseDto => (
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
                </div>
            </div>
        </section>
    );
}
 
export default AuthorPage;