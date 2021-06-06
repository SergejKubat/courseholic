import { BsStarFill, BsStar } from 'react-icons/bs';

const Review = (props) => {

    const runCallback = (cb) => {
        return cb();
    }

    return (
        <li className="cm-course__reviews-comments-item">
            <div className="cm-course__reviews-comments-info">
                <div className="cm-course__reviews-comments-creator">
                    <img
                        src={props.review.creator.avatar}
                        alt={props.review.creator.username}
                        className="cm-course__reviews-comments-img"
                    />
                    <div className="cm-course__reviews-comments-creator__details">
                        <h4 className="cm-course__reviews-comments-name">{props.review.creator.firstName + ' ' + props.review.creator.lastName}</h4>
                        <p className="cm-course__reviews-comments-creator__username">@{props.review.creator.username}</p>
                    </div>
                </div>
                <div className="cm-course__reviews-comments-date">{props.review.dateCreated}</div>
                <div className="cm-course__reviews-comments-details">
                <div className="cm-course__reviews-comments-stars">
                    {
                        runCallback(() => {
                            const row = [];
                            for (var i = 0; i < 5; i++) {
                                const difference = props.review.rating - i;
                                if (difference >= 1) {
                                    row.push(<BsStarFill />);
                                    continue;
                                }
                                row.push(<BsStar />);
                            }
                            return row;
                        })
                    }
                </div>
                <p className="cm-course__reviews-comments-content">
                    {props.review.comment}
                </p>
                <div className="cm-course__reviews-comments-actions">
                    {/* <button className="cm-btn">Update</button>
                    <button className="cm-btn">Delete</button>*/}
                </div>
                </div>
            </div>
            <div></div>
        </li>
    );
}
 
export default Review;