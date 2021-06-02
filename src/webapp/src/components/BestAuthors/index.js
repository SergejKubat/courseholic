const BestAuthors = () => {
    return (
        <section className="cm-featured-instructors">
                <h1 className="cm-heading">
                <span className="cm-heading__main">Learn from our best authors</span>
                <span className="cm-heading__sub">Best Authors</span>
                <span className="cm-heading__hr"></span>
                <span className="cm-all-categories__hr"></span>
                </h1>
                <div className="cm-featured-instructors__row">
                <div className="cm-featured-instructors__col">
                    <div className="cm-featured-instructors__item">
                    <div className="cm-featured-instructors__thumb">
                        <a>
                        <img
                            src="{{ autor.AUTOR_SLIKA }}"
                            alt="{{ autor.AUTOR_IME }}"
                            height="140"
                            width="140"
                            className="cm-featured-instructors__img"
                        />
                        </a>
                    </div>
                    <a>
                        <h3>Bla</h3>
                    </a>
                    <span>ddd</span>
                    <span className="cm-all-categories__hr"></span>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Delectus, soluta!
                    </p>
                    </div>
                </div>
                </div>
            </section>
    );
}
 
export default BestAuthors;