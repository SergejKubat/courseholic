function Home() {
    return (
        <main className="cm-main">

            <section class="cm-poster">
                <h1 class="cm-poster-heading__main">KursMania</h1>
                <h2 class="cm-poster-heading__sub">
                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                </h2>
            </section>

            <section class="cm-all-categories">
                <h1 class="cm-heading">
                <span class="cm-heading__main">Dobrodošli na KursManiju.</span>
                <span class="cm-heading__sub">Kategorije Kurseva</span>
                <span class="cm-heading__hr"></span>
                </h1>
                <div class="cm-categories-list">
                
                </div>
            </section>

            <section class="cm-about">
                <div class="cm-about__details">
                <h1>O našoj kompaniji</h1>
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
                <button class="cm-btn-outline">Više detalja</button>
                </div>
                <div class="cm-about__img">
                <img src="../assets/img/about-us.jpg" alt="About us" />
                </div>
            </section>

            <section class="cm-courses">
                <h1 class="cm-heading">
                <span class="cm-heading__main">Pogledajte neke od najpopularnijih kurseva</span>
                <span class="cm-heading__sub">Popularni kursevi</span>
                <span class="cm-heading__hr"></span>
                <span class="cm-all-categories__hr"></span>
                </h1>

                <div class="cm-courses__container">
                <div class="cm-courses__content">
                    <div class="cm-courses__list">
                    </div>
                </div>
                </div>
            </section>

            <section class="cm-numbers">
                <div class="cm-numbers__row">
                <div class="cm-numbers__col">
                    <div class="cm-numbers__main">
                    <h1>100%</h1>
                    </div>
                    <div class="cm-numbers__sub">
                    <span>Stepen uspeha</span>
                    </div>
                </div>
                <div class="cm-numbers__col">
                    <div class="cm-numbers__main">
                    <h1>5+</h1>
                    </div>
                    <div class="cm-numbers__sub">
                    <span>Godina postojanja</span>
                    </div>
                </div>
                <div class="cm-numbers__col">
                    <div class="cm-numbers__main">
                    <h1>123</h1>
                    </div>
                    <div class="cm-numbers__sub">
                    <span>Studenata</span>
                    </div>
                </div>
                <div class="cm-numbers__col">
                    <div class="cm-numbers__main">
                    <h1>23</h1>
                    </div>
                    <div class="cm-numbers__sub">
                    <span>Kurseva</span>
                    </div>
                </div>
                </div>
            </section>

            <section class="cm-featured-instructors">
                <h1 class="cm-heading">
                <span class="cm-heading__main">Učite od naših najboljih instruktora</span>
                <span class="cm-heading__sub">Najbolji instruktori</span>
                <span class="cm-heading__hr"></span>
                <span class="cm-all-categories__hr"></span>
                </h1>
                <div class="cm-featured-instructors__row">
                <div class="cm-featured-instructors__col">
                    <div class="cm-featured-instructors__item">
                    <div class="cm-featured-instructors__thumb">
                        <a>
                        <img
                            src="{{ autor.AUTOR_SLIKA }}"
                            alt="{{ autor.AUTOR_IME }}"
                            height="140"
                            width="140"
                            class="cm-featured-instructors__img"
                        />
                        </a>
                    </div>
                    <a>
                        <h3>Bla</h3>
                    </a>
                    <span>ddd</span>
                    <span class="cm-all-categories__hr"></span>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Delectus, soluta!
                    </p>
                    </div>
                </div>
                </div>
            </section>

            <section class="cm-sponsors">
                <h1 class="cm-heading">
                <span class="cm-heading__main">Organizacije koje koriste naše usluge.</span>
                <span class="cm-heading__sub">Naši sponzori</span>
                <span class="cm-heading__hr"></span>
                <span class="cm-all-categories__hr"></span>
                </h1>
                <div class="cm-sponsors__row">
                <div class="cm-sponsors__col">
                    <a href="#">
                    <img
                        src="../assets/img/sponsor-1.png"
                        alt="Sponzor 1"
                        class="cm-sponsors__logo"
                    />
                    </a>
                </div>
                <div class="cm-sponsors__col">
                    <a href="#">
                    <img
                        src="../assets/img/sponsor-2.png"
                        alt="Sponzor 1"
                        class="cm-sponsors__logo"
                    />
                    </a>
                </div>
                <div class="cm-sponsors__col">
                    <a href="#">
                    <img
                        src="../assets/img/sponsor-3.png"
                        alt="Sponzor 1"
                        class="cm-sponsors__logo"
                    />
                    </a>
                </div>
                <div class="cm-sponsors__col">
                    <a href="#">
                    <img
                        src="../assets/img/sponsor-4.png"
                        alt="Sponzor 1"
                        class="cm-sponsors__logo"
                    />
                    </a>
                </div>
                <div class="cm-sponsors__col">
                    <a href="#">
                    <img
                        src="../assets/img/sponsor-5.png"
                        alt="Sponzor 1"
                        class="cm-sponsors__logo"
                    />
                    </a>
                </div>
                <div class="cm-sponsors__col">
                    <a href="#">
                    <img
                        src="../assets/img/sponsor-6.png"
                        alt="Sponzor 1"
                        class="cm-sponsors__logo"
                    />
                    </a>
                </div>
                </div>
            </section>

            <section class="cm-became-teacher">
                <div class="cm-became-teacher__default">
                <div class="cm-became-teacher__wrapper">
                    <div class="cm-became-teacher__icon">
                    <i class="fa fa-envelope-o" aria-hidden="true"></i>
                    </div>
                    <div class="cm-became-teacher__content">
                    <h2>Postanite autor</h2>
                    <p>
                        Lorem ipsum dolor sit amet consectetur, adipisicing elit. Possimus
                        vero.
                    </p>
                    </div>
                    <div class="cm-became-teacher__button">
                    <button class="cm-btn-outline cm-btn-white">Pridružite se</button>
                    </div>
                </div>
                </div>
            </section>

        </main>
    );
}

export default Home;