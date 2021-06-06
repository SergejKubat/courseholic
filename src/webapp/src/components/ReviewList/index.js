import Review from '../Review';

const ReviewList = (props) => {

    return (
        <div className="cm-course__reviews-comments">
            <h3 className="cm-course__reviews-heading">List of reviews</h3>
            <ul className="cm-course__reviews-comments-list">
            <div>
                {props.reviews.map(review => (
                    <Review
                    key={review.id}
                    review={review}
                    />
                ))}
            </div>
            </ul>
            <div>
                
            </div>
        </div>
    );
}
 
export default ReviewList;