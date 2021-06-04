import { Link } from "react-router-dom";

const AuthorCard = (props) => {
    return (
        <div className="cm-featured-instructors__col">
            <div className="cm-featured-instructors__item">
                <div className="cm-featured-instructors__thumb">
                    <img
                            src={props.avatar}
                            alt={props.username}
                            height="140"
                            width="140"
                            className="cm-featured-instructors__img"
                    />           
                </div>
                <Link to={'/author/' + props.username}>
                    <h3>{props.firstName} {props.lastName}</h3>
                </Link>
                <span>{props.profession}</span>
                <span className="cm-all-categories__hr"></span>
                <p>
                    {props.description.substring(0, 50) + '...'}
                </p>
            </div>
        </div>
    );
}

export default AuthorCard;