import { Link } from "react-router-dom";

const CourseAuthor = (props) => {
    return (
        <div className="cm-course__author-info">
            <h3 className="cm-course__author-info-heading">Author</h3>
            <div className="cm-course__author-info-row">
                <div className="cm-course__author-info-avatar">
                    <img
                        src={props.author.avatar}
                        alt={props.author.username}
                        className="cm-course__author-info-img"
                    />
                </div>
                <div className="cm-course__author-info-content">
                    <h3 className="cm-course__author-info-name">{props.author.firstName + ' ' + props.author.lastName}</h3>
                    <p className="cm-course__author-info-details">{props.author.description}</p>
                    <button className="cm-btn">
                        <Link to={'/author/' + props.author.username}>
                            Details
                            </Link>
                    </button>
                </div>
            </div>
        </div>
    );
}

export default CourseAuthor;