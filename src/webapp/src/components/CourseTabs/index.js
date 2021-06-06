import { useState } from "react";

import CourseOverview from './overview';
import CourseContent from './content';
import CourseAuthor from './author';
import CourseReviews from './reviews'

const CourseTabs = (props) => {

    const [isOverviewVisible, setIsOverviewVisible] = useState(true);
    const [isContentVisible, setIsContentVisible] = useState(false);
    const [isAuthorVisible, setIsAuthorVisible] = useState(false);
    const [isReviewsVisible, setIsReviewsVisible] = useState(false);

    const resetAll = () => {
        setIsOverviewVisible(false);
        setIsContentVisible(false);
        setIsAuthorVisible(false);
        setIsReviewsVisible(false);
    }

    const setVisibility = (index) => {
        resetAll();
        if (index === 1) {
            setIsOverviewVisible(true);
        }
        if (index === 2) {
            setIsContentVisible(true);
        }
        if (index === 3) {
            setIsAuthorVisible(true);
        }
        if (index === 4) {
            setIsReviewsVisible(true);
        }
    }

    return (
        <div>
            <div className="cm-course__tabs">

                <ul className="cm-course__tabs-nav">
                    <li className={`cm-course__tabs-tab ${isOverviewVisible ? 'active' : ''}`} onClick={() => setVisibility(1)}>
                        <span className="cm-course__tabs-tab-text">Overview</span>
                    </li>
                    <li className={`cm-course__tabs-tab ${isContentVisible ? 'active' : ''}`} onClick={() => setVisibility(2)}>
                        <span className="cm-course__tabs-tab-text">Content</span>
                    </li>
                    <li className={`cm-course__tabs-tab ${isAuthorVisible ? 'active' : ''}`} onClick={() => setVisibility(3)}>
                        <span className="cm-course__tabs-tab-text">Author</span>
                    </li>
                    <li className={`cm-course__tabs-tab ${isReviewsVisible ? 'active' : ''}`} onClick={() => setVisibility(4)}>
                        <span className="cm-course__tabs-tab-text">Reviews</span>
                    </li>
                </ul>

                {isOverviewVisible && <CourseOverview courseDto={props.courseDto} />}
                {isContentVisible && <CourseContent sections={props.courseDto.sections} />}
                {isAuthorVisible && <CourseAuthor author={props.courseDto.author} />}
                {isReviewsVisible && <CourseReviews courseDto={props.courseDto} />}

            </div>
        </div>
    );
}
 
export default CourseTabs;