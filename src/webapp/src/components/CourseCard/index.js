import { NavLink } from "react-router-dom"

import { FaUserTie, FaUserGraduate} from 'react-icons/fa';
import { BsStarFill, BsStarHalf, BsStar } from 'react-icons/bs';

const CourseCard = (props) => {

    const runCallback = (cb) => {
        return cb();
      };

    return (
        <div class="cm-course-item">
            <div class="cm-course-item__thumbnail">
                <img
                src={props.picture}
                alt={props.name}
                class="cm-course-item__img"
                />
                <div class="cm-course-item__hidden">
                <button class="cm-btn">
                    <NavLink to={'/author/' + props.authorUsername + '/courses/' + props.id}>
                        Details
                    </NavLink>
                </button>
                </div>
                <span class="cm-course-item__popular">Popular</span>
                <span class="cm-course-item__price">$ {props.price}</span>
                <span class="cm-course-item__rating">
                <span class="average">{props.averageRating}</span>
                {
                    runCallback(() => {
                        const row = [];
                        for (var i = 0; i < 5; i++) {
                            const difference = props.averageRating - i;
                            if (difference >= 1) {
                                row.push(<BsStarFill />);
                                continue;
                            }
                            if (difference < 1 && difference > 0) {
                                row.push(<BsStarHalf />);
                                continue;
                            }
                            row.push(<BsStar />);
                        }
                        return row;
                      })
                }
                <span class="count">({props.numberOfRating})</span>
                </span>
            </div>
            <div class="cm-course-item__details">
                <h3>{props.name}</h3>
                <div class="cm-course-item__info">
                <span>
                    <FaUserTie />
                    <NavLink to={'/author/' + props.authorUsername}>
                        {props.authorFirstName} {props.authorLastName}
                    </NavLink>
                </span>
                <span>
                    <FaUserGraduate />
                    {props.numberOfStudents}
                </span>
                </div>
            </div>
        </div>
    );
}
 
export default CourseCard;