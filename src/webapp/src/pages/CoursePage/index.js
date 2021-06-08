import { useParams } from "react-router";
import { useEffect, useState } from 'react';
import { Link } from "react-router-dom";

import AuthService from '../../services/AuthService';
import CourseService from '../../services/CourseService';
import PurchaseRecordService from '../../services/PurchaseRecordService';

import CourseTabs from '../../components/CourseTabs';
import CourseCard from '../../components/CourseCard';
import Modal from '../../components/Modal';

import ReactPlayer from 'react-player';

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

import Moment from 'react-moment';

import { BsStarFill, BsStarHalf, BsStar } from 'react-icons/bs';

import newCourse1 from '../../assets/img/course-rec-1.jpg';
import newCourse2 from '../../assets/img/course-rec-2.jpg';
import newCourse3 from '../../assets/img/course-rec-3.jpg';
import newCourse4 from '../../assets/img/course-rec-4.jpg';

const CoursePage = () => {

    const params = useParams();

    const [courseDto, setCourseDto] = useState({
        course: {},
        author: {},
        category: {},
        language: {},
        sections: [],
        reviews: []
    });

    const [courseResponse, setCourseResponse] = useState([]);

    const [isErrorVisible, setIsErrorVisible] = useState(false);

    const [isPurchased, setIsPurchased] = useState(false);

    const [isLoading, setIsLoading] = useState(false);

    useEffect(
        () => {
            setIsLoading(true);
            CourseService.getCourseById(params.username, params.courseId).then(response => {
                setCourseDto(response.data);
                const courseId = response.data.course.id;

                CourseService.getCoursesByCategoryId(response.data.category.id).then(response => {
                    const allCourses = response.data.courses;
                    const coursesWithoutCurrent = allCourses.filter(courseDtoItem => courseDtoItem.course.id !== courseId);
                    setCourseResponse(coursesWithoutCurrent);
                    setIsLoading(false);
                });

                if (AuthService.isAuthenticated()) {
                    PurchaseRecordService.getAllByUsername(AuthService.getCurrentUser().username).then(response => {
                        const courseList = response.data;
                        const filteredCourseList = courseList.filter(courseDtoItem => courseDtoItem.course.id === courseId);
                        setIsPurchased(filteredCourseList.length === 1);
                    });
                }
            });
        },
        [params, isPurchased]
    );

    const runCallback = (cb) => {
        return cb();
    }

    const notify = () => {
        if (isPurchased) return;
        toast.info("Interested in this course? Purchase it today!", {
            style: {fontSize: '1.6rem'},
            draggable: false,
            autoClose: 5000,
            position: toast.POSITION.TOP_CENTER
        });
    }

    const buyCourse = (e) => {
        if (!AuthService.isAuthenticated()) {
            setIsErrorVisible(true);
            return;
        }
        
        PurchaseRecordService.createPurchaseRecord(courseDto.course.id).then(response => {
            setIsPurchased(true);
        }).catch(error => {
            //console.log(error.response);
        });
    }

    return (
        <section className="cm-course">

            {isLoading && (
                <div className="cm-categories-list">
                    <div className="lds-ring"><div></div><div></div><div></div><div></div></div>
                </div>
            )}

            {!isLoading && (
                <div className="cm-course__container">
                    <div className="cm-course__row">
                        <div className="cm-course__primary">
                            <article className="cm-course__content">

                                <div className="cm-course__header">
                                    <h1>{courseDto.course.name}</h1>
                                    <div className="cm-course__meta">
                                        <div className="cm-course__author">
                                            <img
                                                src={courseDto.author.avatar}
                                                alt={courseDto.author.username}
                                                className="cm-course__author-avatar"
                                            />
                                            <div className="cm-course__author-contain">
                                                <label className="cm-course__author-job">Author</label>
                                                <div className="cm-course__author-name">
                                                    <Link to={'/author/' + courseDto.author.username}>
                                                        {courseDto.author.firstName + ' ' + courseDto.author.lastName}
                                                    </Link>
                                                </div>
                                            </div>
                                        </div>
                                        <div className="cm-course__category">
                                            <label>Category</label>
                                            <div className="cm-course__category-name">
                                                <Link to="/search" className="cm-course__category-link">
                                                    {courseDto.category.name}
                                                </Link>
                                            </div>
                                        </div>
                                        <div className="cm-course__review">
                                            <label>Reviews ({courseDto.numberOfRatings})</label>
                                            <span className="cm-course__review-average">
                                                {courseDto.averageRating}
                                            </span>
                                            <div className="cm-course__stars">
                                                {
                                                    runCallback(() => {
                                                        const row = [];
                                                        for (var i = 0; i < 5; i++) {
                                                            const difference = courseDto.averageRating - i;
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
                                            </div>
                                        </div>
                                    </div>

                                    <div className="cm-course__payment">
                                        <div className="cm-course__price">
                                            <span className="cm-course__price-old">29.99 $</span>
                                            <span className="cm-course__price-new">{courseDto.course.price} $</span>
                                        </div>
                                        <div className="cm-course__button">
                                            {!isPurchased && (
                                                <button className="cm-btn" onClick={(e) => buyCourse(e)}>Buy Course</button>
                                            )}
                                        </div>
                                    </div>
                                    <p className="cm-course__last-updated">Last updated: <b><Moment fromNow>{courseDto.course.lastUpdated}</Moment></b></p>
                                </div>

                                <div className="cm-course__thumbnail">
                                    <div className="cm-course__thumbnail-img">
                                        <ReactPlayer 
                                        url="https://www.youtube.com/watch?v=GhQdlIFylQ8&ab_channel=freeCodeCamp.org" 
                                        controls={true} 
                                        light={courseDto.course.picture}
                                        width="100%"
                                        height="70rem"
                                        onStart={() => notify()} 
                                        />
                                    </div>
                                    <ToastContainer />
                                </div>

                                <CourseTabs
                                    courseDto={courseDto}
                                />

                                <div className="cm-course__related">
                                    <h3 className="cm-course__related-heading">Related courses</h3>
                                    <div className="cm-course__related-list">
                                        {courseResponse.map(courseRes => (
                                            <CourseCard
                                                key={courseRes.course.id}
                                                id={courseRes.course.id}
                                                name={courseRes.course.name}
                                                picture={courseRes.course.picture}
                                                price={courseRes.course.price}
                                                averageRating={courseRes.averageRating}
                                                numberOfRatings={courseRes.numberOfRatings}
                                                authorUsername={courseRes.author.username}
                                                authorFirstName={courseRes.author.firstName}
                                                authorLastName={courseRes.author.lastName}
                                                numberOfStudents={courseRes.numberOfStudents}
                                            />
                                        ))}
                                    </div>
                                </div>

                            </article>
                        </div>

                        <aside className="cm-course__secondary">
                            <article className="cm-course__recent-courses">
                                <h3>Newest courses</h3>
                                <div className="cm-course__recent-courses-content">
                                    <div className="cm-course__recent-courses-course">
                                        <div className="cm-course__recent-courses-thumb">
                                            <img
                                                src={newCourse1}
                                                alt="UX/UI Principles"
                                                className="cm-course__recent-courses-img"
                                            />
                                        </div>
                                        <div className="cm-course__recent-courses-detail">
                                            <h2 className="cm-course__recent-courses-title">UX/UI Principles</h2>
                                            <div className="cm-course__recent-courses-meta">
                                                <div className="cm-course__recent-courses-price">$18.99</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="cm-course__recent-courses-course">
                                        <div className="cm-course__recent-courses-thumb">
                                            <img
                                                src={newCourse2}
                                                alt="Audio production"
                                                className="cm-course__recent-courses-img"
                                            />
                                        </div>
                                        <div className="cm-course__recent-courses-detail">
                                            <h2 className="cm-course__recent-courses-title">
                                                Audio production
                                    </h2>
                                            <div className="cm-course__recent-courses-meta">
                                                <div className="cm-course__recent-courses-price">$11.99</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="cm-course__recent-courses-course">
                                        <div className="cm-course__recent-courses-thumb">
                                            <img
                                                src={newCourse3}
                                                alt="Java for beginners"
                                                className="cm-course__recent-courses-img"
                                            />
                                        </div>
                                        <div className="cm-course__recent-courses-detail">
                                            <h2 className="cm-course__recent-courses-title">
                                                Java for beginners
                                    </h2>
                                            <div className="cm-course__recent-courses-meta">
                                                <div className="cm-course__recent-courses-price">$9.99</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="cm-course__recent-courses-course">
                                        <div className="cm-course__recent-courses-thumb">
                                            <img
                                                src={newCourse4}
                                                alt="Marketing basics"
                                                className="cm-course__recent-courses-img"
                                            />
                                        </div>
                                        <div className="cm-course__recent-courses-detail">
                                            <h2 className="cm-course__recent-courses-title">
                                                Marketing basics
                                    </h2>
                                            <div className="cm-course__recent-courses-meta">
                                                <div className="cm-course__recent-courses-price">$15.99</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </article>
                            <article className="cm-course__ba">
                                <div className="cm-course__ba-content">
                                    <h4 className="cm-course__ba-heading">Bemoce an author</h4>
                                    <div className="cm-course__ba-text">
                                        Lorem Ipsum is simply dummy text of the printing and typesetting
                                        industry. Lorem Ipsum has been the industry’s standard dummy text
                                        ever since. It is a long established fact that a reader will be
                                        distracted by the readable content of a page when looking at its
                                        layout.
                                </div>
                                    <button className="cm-course__ba-btn">Join Us</button>
                                </div>
                            </article>
                        </aside>
                    </div>
                </div>
            )}

            {isErrorVisible && <Modal
                heading='You are not signed in!'
                message="You must sign in to purchase this course."
                btnText="Sign In"
                btnLink="/signin"
                closeMethod={setIsErrorVisible}
            />}
        </section>
    );
}

export default CoursePage;