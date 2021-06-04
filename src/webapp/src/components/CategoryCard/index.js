import { useEffect, useState } from 'react';
import CourseService from '../../services/CourseService';

const CategoryCard = (props) => {

    const [numberOfCourses, setNumberOfCourses] = useState(0);

    useEffect(
        () => {
            CourseService.getCoursesByCategoryId(props.id).then(res => {
                setNumberOfCourses(res.data.totalElements);
            });
        },
        [] 
    );

    return (
        <div class="cm-categories-item" tabindex="0">
            <img
                src={props.image}
                alt={props.name}
                class="cm-categories-img"
            />
            <div class="cm-categories-desc">
                <h4>{props.name}</h4>
                <p>{numberOfCourses} Courses</p>
            </div>
        </div>
    );
}
 
export default CategoryCard;