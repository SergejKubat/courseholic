import ReviewList from '../ReviewList';
import CreateReview from '../CreateReview';

import { BsStarFill, BsStar } from 'react-icons/bs';

const CourseReviews = (props) => {
    return (
        <div className="cm-course__reviews">
            <h3 className="cm-course__reviews-heading">Course reviews ({props.courseDto.numberOfRatings})</h3>
            <p className="cm-course__reviews-average">Average rating is {props.courseDto.averageRating}</p>
            <div className="cm-course__reviews-rate">
                <BsStarFill />
                <BsStarFill />
                <BsStarFill />
                <BsStarFill />
                <BsStarFill />
                <div className="cm-course__reviews-bar">
                    <div className="cm-course__reviews-progress" style={{ width: props.courseDto.percentOfFiveRating + '%' }}></div>
                </div>
                <span>{props.courseDto.percentOfFiveRating}%</span>
            </div>
            <div className="cm-course__reviews-rate">
                <BsStarFill />
                <BsStarFill />
                <BsStarFill />
                <BsStarFill />
                <BsStar />
                <div className="cm-course__reviews-bar">
                    <div className="cm-course__reviews-progress" style={{ width: props.courseDto.percentOfFourRating + '%' }}></div>
                </div>
                <span>{props.courseDto.percentOfFourRating}%</span>
            </div>
            <div className="cm-course__reviews-rate">
                <BsStarFill />
                <BsStarFill />
                <BsStarFill />
                <BsStar />
                <BsStar />
                <div className="cm-course__reviews-bar">
                    <div className="cm-course__reviews-progress" style={{ width: props.courseDto.percentOfThreeRating + '%' }}></div>
                </div>
                <span>{props.courseDto.percentOfThreeRating}%</span>
            </div>
            <div className="cm-course__reviews-rate">
                <BsStarFill />
                <BsStarFill />
                <BsStar />
                <BsStar />
                <BsStar />
                <div className="cm-course__reviews-bar">
                    <div className="cm-course__reviews-progress" style={{ width: props.courseDto.percentOfTwoRating + '%' }}></div>
                </div>
                <span>{props.courseDto.percentOfTwoRating}%</span>
            </div>
            <div className="cm-course__reviews-rate">
                <BsStarFill />
                <BsStar />
                <BsStar />
                <BsStar />
                <BsStar />
                <div className="cm-course__reviews-bar">
                    <div className="cm-course__reviews-progress" style={{ width: props.courseDto.percentOfOneRating + '%' }}></div>
                </div>
                <span>{props.courseDto.percentOfOneRating}%</span>
            </div>
            <ReviewList
                key={props.courseDto.course.id}
                reviews={props.courseDto.reviews}
            />
            <CreateReview
            courseId={props.courseDto.course.id}
            />
        </div>
    );
}

export default CourseReviews;