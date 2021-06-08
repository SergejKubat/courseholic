import { useState } from 'react';
import StarRatingComponent from 'react-star-rating-component';

import ReviewService from '../../services/ReviewService';

const CreateReview = (props) => {

    const [ratingValue, setRatingValue] = useState(0);

    const [starsError, setStarsError] = useState(false);

    const [comment, setComment] = useState("");
    const [commentError, setCommentError] = useState(false);

    const [responseErrorMessage, setResponseErrorMessage] = useState(false);
    const [responseError, setResponseError] = useState(false);

    const onStarClick = (nextValue, prevValue, name) => {
        setRatingValue(nextValue);
    }

    const submit = (event) => {

        event.preventDefault();

        if (!ratingValue) {
            setStarsError(true);
            return;
        }
        setStarsError(false);

        const commentValue = document.getElementById('comment').value.trim();
        if (commentValue.length < 10 || commentValue.length > 1000) {
            setCommentError(true);
            return;
        }
        setCommentError(false);
        setComment(commentValue);

        const data = {
            comment: commentValue,
            rating: ratingValue
        }

        ReviewService.createReview(props.courseId, data).then(response => {
            console.log(response);
            //window.location.reload();
        }).catch(error => {
            setResponseError(true);
            setResponseErrorMessage(error.response.data.message)
        });
    }

    return (
        <div className="cm-course__reviews-create">
            <h1>Your rating:</h1>
            <div className="cm-course__reviews-create-stars">
                <StarRatingComponent
                name="Rate course"
                starCount={5}
                starColor="#b6e633"
                emptyStarColor="#73726c"
                value={ratingValue}
                onStarClick={onStarClick}
                />
            </div>
            {starsError && <div className="cm-course__reviews-create-error">You must enter rating</div>}
            <div className="cm-course__reviews-create-content">
                <form className="cm-course__reviews-create-form" onSubmit={(e) => submit(e)}>
                    <div className="cm-course__reviews-create-form-control">
                        <label htmlFor="comment" className="cm-course__reviews-create-form-label">Comment:</label>
                        <textarea
                            name="comment"
                            id="comment"
                            className="cm-course__reviews-create-form-textarea"
                            cols="30"
                            rows="8"
                            placeholder="Enter a comment"
                        ></textarea>
                    </div>
                    {commentError && <div className="cm-course__reviews-create-error">Comment length can be minimum 10 and maximum 1000 characters</div>}
                    <div className="cm-course__reviews-create-form-submit">
                        <button type="submit" className="cm-btn">Submit</button>
                    </div>
                </form>
                {responseError && (
                    <div className="cm-course__reviews-create-error">{responseErrorMessage}</div>
                )}
            </div>
        </div>
    );
}
 
export default CreateReview;