import AuthService from '../../services/AuthService';
import ReviewService from '../../services/ReviewService';

import { BsStarFill, BsStar } from 'react-icons/bs';

const Review = (props) => {

    const runCallback = (cb) => {
        return cb();
    }

    const checkCreator = () => {
        if (!AuthService.isAuthenticated()) return false;

        const currentUsername = AuthService.getCurrentUser().username;

        return currentUsername === props.review.creator.username;
    }

    const deleteReview = () => {
        ReviewService.deleteReview(props.review.id).then(response => {
            console.log(response.data);
        }).catch(error => {
            //console.log(error.response.data);
        });
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
                    {checkCreator() && (
                        <div className="cm-course__reviews-comments-actions">
                            <button className="cm-btn">Update</button>
                            <button className="cm-btn" onClick={() => deleteReview()}>Delete</button>
                        </div>
                    )}
                </div>
            </div>
            <div></div>
        </li>
    );
}
 
export default Review;