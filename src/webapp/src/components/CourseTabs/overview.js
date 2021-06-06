import { FaUserGraduate, FaLevelUpAlt, FaLanguage } from 'react-icons/fa';
import { BiTime } from 'react-icons/bi';
import { RiRefund2Fill } from 'react-icons/ri';

const CourseOverview = (props) => {
    return (
        <div className="cm-course__overview">
            <div className="cm-course_row" style={{ display: 'flex' }}>
                <div className="cm-course__overview-text">
                    <div className="cm-course__overview-desc">
                        <p>{props.courseDto.course.description}</p>
                    </div>
                </div>
                <div className="cm-course__overview-info">
                    <h3>Characteristics</h3>
                    <ul>
                        <li>
                            <FaUserGraduate />
                            <span className="cm-course__overview-info-label">Students</span>
                            <span className="cm-course__overview-info-value">{props.courseDto.numberOfStudents}</span>
                        </li>
                        <li>
                            <BiTime />
                            <span className="cm-course__overview-info-label">Duration</span>
                            <span className="cm-course__overview-info-value">22h 5m</span>
                        </li>
                        <li>
                            <FaLevelUpAlt />
                            <span className="cm-course__overview-info-label">Skills</span>
                            <span className="cm-course__overview-info-value">{props.courseDto.category.name}</span>
                        </li>
                        <li>
                            <FaLanguage />
                            <span className="cm-course__overview-info-label">Language</span>
                            <span className="cm-course__overview-info-value">{props.courseDto.language.name}</span>
                        </li>
                        <li>
                            <RiRefund2Fill />
                            <span className="cm-course__overview-info-label">Refunds</span>
                            <span className="cm-course__overview-info-value">1 month</span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    );
}

export default CourseOverview;