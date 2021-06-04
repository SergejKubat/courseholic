import { useEffect, useState } from "react";

import CourseCard from '../CourseCard';

import CourseService from '../../services/CourseService';

const PopularCourses = () => {

    const [courseResponse, setCourseResponse] = useState([]);

    useEffect(() => {
        CourseService.getAllCourses().then(res => {
            setCourseResponse(res.data.courses);
        });
    }, []);

    return (
        <section className="cm-courses">
                <h1 className="cm-heading">
                <span className="cm-heading__main">See what other people are interested in</span>
                <span className="cm-heading__sub">Popular Courses</span>
                <span className="cm-heading__hr"></span>
                <span className="cm-all-categories__hr"></span>
                </h1>
                <div className="cm-courses__container">
                <div className="cm-courses__content">
                    <div className="cm-courses__list">
                        {courseResponse.map(courseDto => (
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
 
export default PopularCourses;