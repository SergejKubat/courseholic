import { useEffect, useState } from 'react';
import CourseService from '../../services/CourseService';

const CategoryCard = (props) => {

    const [numberOfCourses, setNumberOfCourses] = useState(0);

    useEffect(
        () => {
            CourseService.getCoursesByCategoryId(props.id).then(res => {
                setNumberOfCourses(res.data.courses.length);
            });
        },
        [props.id] 
    );

    return (
        <div className="cm-categories-item" tabIndex="0">
            <img
                src={props.image}
                alt={props.name}
                className="cm-categories-img"
            />
            <div className="cm-categories-desc">
                <h4>{props.name}</h4>
                <p>{numberOfCourses} Courses</p>
            </div>
        </div>
    );
}
 
export default CategoryCard;