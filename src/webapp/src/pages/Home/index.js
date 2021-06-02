import BestAuthors from './../../components/BestAuthors';
import Categories from './../../components/Categories';
import PopularCourses from './../../components/PopularCourses';
import Sponsors from './../../components/Sponsors';

import AboutUs from "./../../assets/img/about-us.jpg";

function Home() {
    return (
        <main className="cm-main">

            <section className="cm-poster">
                <h1 className="cm-poster-heading__main">Courseholic</h1>
                <h2 className="cm-poster-heading__sub">
                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                </h2>
            </section>

            <Categories />

            <section className="cm-about">
                <div className="cm-about__details">
                <h1>About our company</h1>
                <p>
                    Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio.
                    Quisque volutpat mattis eros.
                </p>
                <p>
                    Nullam malesuada erat ut turpis. Suspendisse urna nibh, viverra non,
                    semper suscipit, posuere a, pede.
                </p>
                <p>
                    Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris
                    sit amet orci. Aenean dignissim pellentesque felis.
                </p>
                <button className="cm-btn-outline">More details</button>
                </div>
                <div className="cm-about__img">
                <img src={AboutUs} alt="About us" />
                </div>
            </section>

            <PopularCourses />

            <section className="cm-numbers">
                <div className="cm-numbers__row">
                <div className="cm-numbers__col">
                    <div className="cm-numbers__main">
                    <h1>100%</h1>
                    </div>
                    <div className="cm-numbers__sub">
                    <span>Success Rate</span>
                    </div>
                </div>
                <div className="cm-numbers__col">
                    <div className="cm-numbers__main">
                    <h1>5+</h1>
                    </div>
                    <div className="cm-numbers__sub">
                    <span>Years of Service</span>
                    </div>
                </div>
                <div className="cm-numbers__col">
                    <div className="cm-numbers__main">
                    <h1>123</h1>
                    </div>
                    <div className="cm-numbers__sub">
                    <span>Students</span>
                    </div>
                </div>
                <div className="cm-numbers__col">
                    <div className="cm-numbers__main">
                    <h1>23</h1>
                    </div>
                    <div className="cm-numbers__sub">
                    <span>Courses</span>
                    </div>
                </div>
                </div>
            </section>

            <BestAuthors />

            <Sponsors />

            <section className="cm-became-teacher">
                <div className="cm-became-teacher__default">
                <div className="cm-became-teacher__wrapper">
                    <div className="cm-became-teacher__icon">
                    <i className="fa fa-envelope-o" aria-hidden="true"></i>
                    </div>
                    <div className="cm-became-teacher__content">
                    <h2>Become an Author</h2>
                    <p>
                        Lorem ipsum dolor sit amet consectetur, adipisicing elit. Possimus
                        vero.
                    </p>
                    </div>
                    <div className="cm-became-teacher__button">
                    <button className="cm-btn-outline cm-btn-white">Join whit Us</button>
                    </div>
                </div>
                </div>
            </section>

        </main>
    );
}

export default Home;