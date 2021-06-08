import { Link } from "react-router-dom"

import { FaUserTie, FaUserGraduate } from 'react-icons/fa';
import { BsStarFill, BsStarHalf, BsStar } from 'react-icons/bs';

const CourseCard = (props) => {

    const runCallback = (cb) => {
        return cb();
    };

    return (
        <div className="cm-course-item">
            <div className="cm-course-item__thumbnail">
                <img
                    src={props.picture}
                    alt={props.name}
                    className="cm-course-item__img"
                />
                <div className="cm-course-item__hidden">
                    <Link to={'/author/' + props.authorUsername + '/courses/' + props.id}>
                        <button className="cm-btn">
                            Details
                        </button>
                    </Link>
                </div>
                <span className="cm-course-item__popular">Popular</span>
                <span className="cm-course-item__price">$ {props.price}</span>
                <span className="cm-course-item__rating">
                    <span className="average">{props.averageRating}</span>
                    {
                        runCallback(() => {
                            const row = [];
                            for (var i = 0; i < 5; i++) {
                                const difference = props.averageRating - i;
                                if (difference >= 1) {
                                    row.push(<BsStarFill key={i} />);
                                    continue;
                                }
                                if (difference < 1 && difference > 0) {
                                    row.push(<BsStarHalf key={i} />);
                                    continue;
                                }
                                row.push(<BsStar key={i} />);
                            }
                            return row;
                        })
                    }
                    <span className="count">({props.numberOfRatings})</span>
                </span>
            </div>
            <div className="cm-course-item__details">
                <h3>{props.name}</h3>
                <div className="cm-course-item__info">
                    <span>
                        <FaUserTie />
                        <Link to={'/author/' + props.authorUsername}>
                            {props.authorFirstName} {props.authorLastName}
                        </Link>
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