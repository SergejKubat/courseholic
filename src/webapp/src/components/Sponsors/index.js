import Sponsor1 from "./../../assets/img/sponsor-1.png"
import Sponsor2 from "./../../assets/img/sponsor-2.png"
import Sponsor3 from "./../../assets/img/sponsor-3.png"
import Sponsor4 from "./../../assets/img/sponsor-4.png"
import Sponsor5 from "./../../assets/img/sponsor-5.png"
import Sponsor6 from "./../../assets/img/sponsor-6.png"

const Sponsors = () => {
    return (
        <section className="cm-sponsors">
                <h1 className="cm-heading">
                <span className="cm-heading__main">Organizations that use our services.</span>
                <span className="cm-heading__sub">Our Sponsors</span>
                <span className="cm-heading__hr"></span>
                <span className="cm-all-categories__hr"></span>
                </h1>
                <div className="cm-sponsors__row">
                    <div className="cm-sponsors__col">
                        <img
                            src={Sponsor1}
                            alt="Sponsor 1"
                            className="cm-sponsors__logo"
                        />
                    </div>
                    <div className="cm-sponsors__col">
                        <img
                            src={Sponsor2}
                            alt="Sponsor 2"
                            className="cm-sponsors__logo"
                        />
                    </div>
                    <div className="cm-sponsors__col">
                        <img
                            src={Sponsor3}
                            alt="Sponsor 3"
                            className="cm-sponsors__logo"
                        />
                    </div>
                    <div className="cm-sponsors__col">
                        <img
                            src={Sponsor4}
                            alt="Sponsor 4"
                            className="cm-sponsors__logo"
                        />
                    </div>
                    <div className="cm-sponsors__col">
                        <img
                            src={Sponsor5}
                            alt="Sponsor 5"
                            className="cm-sponsors__logo"
                        />
                    </div>
                    <div className="cm-sponsors__col">
                        <img
                            src={Sponsor6}
                            alt="Sponsor 6"
                            className="cm-sponsors__logo"
                        />
                    </div>
                </div>
            </section>
    );
}
 
export default Sponsors;