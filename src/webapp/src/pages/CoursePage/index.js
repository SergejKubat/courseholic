import { useParams } from "react-router";

import CourseService from '../../services/CourseService';

import { BsStarFill, BsStarHalf, BsStar } from 'react-icons/bs';
import { FaUserGraduate, FaLevelUpAlt, FaLanguage } from 'react-icons/fa';
import { BiTime } from 'react-icons/bi';
import { RiRefund2Fill } from 'react-icons/ri';
import { useEffect } from 'react';

const CoursePage = () => {

    const params = useParams();

    useEffect(
        () => {
            CourseService.getCourseById(params.username, params.courseId).then(response => {
                console.log(response.data);
            });
        },
        []
    );

    return (
        <section className="cm-course">
            <div className="cm-course__container">
                <div className="cm-course__row">
                    <div className="cm-course__primary">
                        <article className="cm-course__content">

                        <div className="cm-course__header">
                            <h1>Course 1</h1>
                            <div className="cm-course__meta">
                                <div className="cm-course__author">
                                    <img
                                    src="{{ autor?.AUTOR_SLIKA }}"
                                    alt="{{ autor?.AUTOR_IME }}"
                                    className="cm-course__author-avatar"
                                    />
                                    <div className="cm-course__author-contain">
                                        <label className="cm-course__author-job">Author</label>
                                        <div className="cm-course__author-name">
                                            <a>Author name</a>
                                        </div>
                                    </div>
                                </div>
                                <div className="cm-course__category">
                                    <label>Category</label>
                                    <div className="cm-course__category-name">
                                    <a href="#" className="cm-course__category-link">category</a>
                                    </div>
                                </div>
                                <div className="cm-course__review">
                                    <label>Reviews</label>
                                    <span className="cm-course__review-average">
                                        4.5
                                    </span>
                                    <div className="cm-course__stars">
                                        <p>Stars...</p>
                                    </div>
                                </div>
                            </div>

                            <div className="cm-course__payment">
                                <div className="cm-course__price">
                                    <span className="cm-course__price-old">29.99 $</span>
                                    <span className="cm-course__price-new">11.99 $</span>
                                </div>
                                <div className="cm-course__button">
                                    <button className="cm-btn">Buy Course</button>
                                </div>
                            </div>
                        </div>

                        <div className="cm-course__thumbnail">
                            <img
                            src="http://localhost:8080/img/course-cpp.jpg"
                            alt="Course 1"
                            className="cm-course__thumbnail-img"
                            />
                        </div>

                        <div className="cm-course_tabs">

                            <ul className="cm-course__tabs-nav">
                                <li className="cm-course__tabs-tab active">
                                    <span class="cm-course__tabs-tab-text">Overview</span>
                                </li>
                                <li className="cm-course__tabs-tab">
                                    <span class="cm-course__tabs-tab-text">Content</span>
                                </li>
                                <li className="cm-course__tabs-tab">
                                    <span class="cm-course__tabs-tab-text">Author</span>
                                </li>
                                <li className="cm-course__tabs-tab">
                                    <span class="cm-course__tabs-tab-text">Reviews</span>
                                </li>
                            </ul>

                            <div className="cm-course__overview" style={{ display: 'flex' }}>
                                <div className="cm-course_row">
                                    <div className="cm-course__overview-text">
                                        <div className="cm-course__overview-desc">
                                            <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Nam magnam nemo non numquam autem, saepe omnis culpa libero hic consequatur repellat placeat voluptas dignissimos incidunt aspernatur fugit accusantium et ducimus. Aliquid accusantium quis recusandae incidunt repellat amet, cupiditate optio dolorum ipsam ut voluptate aspernatur, nostrum nemo adipisci quae vero accusamus.</p>
                                        </div>
                                    </div>
                                    <div className="cm-course__overview-info">
                                        <h3>Characteristics</h3>
                                        <ul>
                                            <li>
                                                <FaUserGraduate />
                                                <span className="cm-course__overview-info-label">Studenti</span>
                                                <span className="cm-course__overview-info-value">23</span>
                                            </li>
                                            <li>
                                                <BiTime />
                                                <span className="cm-course__overview-info-label">Duration</span>
                                                <span className="cm-course__overview-info-value">22h 5m</span>
                                            </li>
                                            <li>
                                                <FaLevelUpAlt />
                                                <span className="cm-course__overview-info-label">Skills</span>
                                                <span className="cm-course__overview-info-value">Category</span>
                                            </li>
                                            <li>
                                                <FaLanguage />
                                                <span className="cm-course__overview-info-label">Language</span>
                                                <span className="cm-course__overview-info-value">language</span>
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

                            <div className="cm-course__content2">
                                <p className="cm-course__content2-heading">Course content</p>
                                <p>....</p>
                            </div>

                            <div className="cm-course__author-info">
                                <h3 className="cm-course__author-info-heading">Autor</h3>
                                <div className="cm-course__author-info-row">
                                <div className="cm-course__author-info-avatar">
                                    <img
                                        src="http://localhost:8080/img/author-3.jpg"
                                        alt="Author"
                                        className="cm-course__author-info-img"
                                    />
                                </div>
                                <div className="cm-course__author-info-content">
                                    <h3 className="cm-course__author-info-name">Author name</h3>
                                    <p className="cm-course__author-info-details">Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt, culpa labore? At officia totam, animi quisquam molestias doloremque vitae! Sapiente?</p>
                                    <button className="cm-btn">Details</button>
                                </div>
                                </div>
                            </div>

                            <div className="cm-course__reviews">
                                <h3 className="cm-course__reviews-heading">Course reviews</h3>
                                <p className="cm-course__reviews-average">Average rating...</p>
                                <div classNameName="cm-course__reviews-rate"></div>
                            </div>
                            </div>

                            <div className="cm-course__related">
                                <h3 className="cm-course__related-heading">Related courses</h3>
                                <div className="cm-course__related-list">
                                    <div>
                                        <p>courses</p>
                                    </div>
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
                                src="../../assets/img/course-rec-1.jpg"
                                alt="UX/UI Principi"
                                className="cm-course__recent-courses-img"
                                />
                            </div>
                            <div className="cm-course__recent-courses-detail">
                                <h2 className="cm-course__recent-courses-title">UX/UI Principi</h2>
                                <div className="cm-course__recent-courses-meta">
                                <div className="cm-course__recent-courses-price">$18.99</div>
                                </div>
                            </div>
                            </div>
                            <div className="cm-course__recent-courses-course">
                            <div className="cm-course__recent-courses-thumb">
                                <img
                                src="../assets/img/course-rec-2.jpg"
                                alt="Audio produkcija"
                                className="cm-course__recent-courses-img"
                                />
                            </div>
                            <div className="cm-course__recent-courses-detail">
                                <h2 className="cm-course__recent-courses-title">
                                Audio produkcija
                                </h2>
                                <div className="cm-course__recent-courses-meta">
                                <div className="cm-course__recent-courses-price">$11.99</div>
                                </div>
                            </div>
                            </div>
                            <div className="cm-course__recent-courses-course">
                            <div className="cm-course__recent-courses-thumb">
                                <img
                                src="../assets/img/course-rec-3.jpg"
                                alt="Java za početnike"
                                className="cm-course__recent-courses-img"
                                />
                            </div>
                            <div className="cm-course__recent-courses-detail">
                                <h2 className="cm-course__recent-courses-title">
                                Java za početnike
                                </h2>
                                <div className="cm-course__recent-courses-meta">
                                <div className="cm-course__recent-courses-price">$9.99</div>
                                </div>
                            </div>
                            </div>
                            <div className="cm-course__recent-courses-course">
                            <div className="cm-course__recent-courses-thumb">
                                <img
                                src="../assets/img/course-rec-4.jpg"
                                alt="Osnove marketinga"
                                className="cm-course__recent-courses-img"
                                />
                            </div>
                            <div className="cm-course__recent-courses-detail">
                                <h2 className="cm-course__recent-courses-title">
                                Osnove marketinga
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
                            <button className="cm-course__ba-btn">Priključite se</button>
                        </div>
                        </article>
                    </aside>
                </div>
            </div>
        </section>
    );
}
 
export default CoursePage;