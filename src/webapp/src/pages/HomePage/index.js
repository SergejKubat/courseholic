import { useEffect, useState } from 'react';
import CategoryCard from '../../components/CategoryCard';
import AuthorCard from '../../components/AuthorCard';
import PopularCourses from '../../components/PopularCourses';
import Sponsors from '../../components/Sponsors';

import CategoryService from '../../services/CategoryService';
import AuthorService from '../../services/AuthorService';

import AboutUs from "./../../assets/img/about-us.jpg";

function HomePage() {

    const [categories, setCategories] = useState([]);
    const [authors, setAuthors] = useState([]);

    const [isLoading, setIsLoading] = useState(false);

    useEffect(
        () => {
            setIsLoading(true);
            CategoryService.getAll().then(response => {
                setCategories(response.data);
                setIsLoading(false);
            });
            AuthorService.getAll().then(response => {
                setAuthors(response.data.slice(0, 3));
            });
        },
        []
    );

    return (
        <main className="cm-main">

            <section className="cm-poster">
                <h1 className="cm-poster-heading__main">Courseholic</h1>
                <h2 className="cm-poster-heading__sub">
                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                </h2>
            </section>

            <section className="cm-all-categories">
                <h1 className="cm-heading">
                <span className="cm-heading__main">Welcome to Courseholic</span>
                <span className="cm-heading__sub">Course categories</span>
                <span className="cm-heading__hr"></span>
                </h1>
                {!isLoading && (
                    <div className="cm-categories-list">
                        {categories.map(category => (
                        <CategoryCard
                        key={category.id}
                        id={category.id}
                        name={category.name}
                        image={category.image}
                        />
                    ))}
                    </div>
                )}
                {isLoading && (
                    <div className="cm-categories-list">
                        <div class="lds-ring"><div></div><div></div><div></div><div></div></div>
                    </div>
                )}
            </section>

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

            <section className="cm-featured-instructors">
                <h1 className="cm-heading">
                <span className="cm-heading__main">Learn from our best authors</span>
                <span className="cm-heading__sub">Best Authors</span>
                <span className="cm-heading__hr"></span>
                <span className="cm-all-categories__hr"></span>
                </h1>
                <div className="cm-featured-instructors__row">
                    {authors.map(author => (
                        <AuthorCard 
                        key={author.username}
                        username={author.username}
                        firstName={author.firstName}
                        lastName={author.lastName}
                        profession={author.profession}
                        description={author.description}
                        avatar={author.avatar}
                        />
                    ))}
                </div>
            </section>

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

export default HomePage;