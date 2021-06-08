import { useEffect, useState } from "react";

import UserService from '../../services/UserService';
import CourseService from '../../services/CourseService';

const Milestone = () => {

    const [numOfCourses, setNumOfCourses] = useState(0);
    const [numOfStudents, setNumOfStudents] = useState(0);

    useEffect(
        () => {
            UserService.getAllUsers().then(response => {
                setNumOfStudents(response.data.totalElements);
            });

            CourseService.getAllCourses().then(response => {
                setNumOfCourses(response.data.totalElements);
            });
        },
        []
    )

    return (
        <section className="cm-numbers">
            <div className="cm-numbers__row">
                <div className="cm-numbers__col">
                    <div className="cm-numbers__main">
                        <h1>100%</h1>
                    </div>
                    <div className="cm-numbers__sub">
                        <span>Success Rate</span>
                    </div>
                </div>
                <div className="cm-numbers__col">
                    <div className="cm-numbers__main">
                        <h1>5+</h1>
                    </div>
                    <div className="cm-numbers__sub">
                        <span>Years of Service</span>
                    </div>
                </div>
                <div className="cm-numbers__col">
                    <div className="cm-numbers__main">
                        <h1>{numOfStudents}</h1>
                    </div>
                    <div className="cm-numbers__sub">
                        <span>Users</span>
                    </div>
                </div>
                <div className="cm-numbers__col">
                    <div className="cm-numbers__main">
                        <h1>{numOfCourses}</h1>
                    </div>
                    <div className="cm-numbers__sub">
                        <span>Courses</span>
                    </div>
                </div>
            </div>
        </section>
    );
}

export default Milestone;