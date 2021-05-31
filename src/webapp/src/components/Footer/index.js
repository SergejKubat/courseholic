function Footer() {
    return (
        <footer className="cm-footer">
            <div className="cm-footer__widgets">
                <div className="cm-footer__container">
                    <div className="cm-footer__wrapper">
                        <div className="cm-footer__row">
                            <div className="cm-footer__col">
                                <div className="cm-footer__text">
                                    <p>
                                        <img
                                            src="../../assets/img/logo-white.png"
                                            alt="Logo white"
                                            className="cm-footer__img"
                                        />
                                    </p>
                                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil
                                        alias, quos adipisci delectus vel consectetur eum quidem dicta
                                        ipsam ex.</p>
                                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
                                        Laudantium nobis eum pariatur.</p>
                                </div>
                            </div>
                            <div className="cm-footer__col">
                                <h4>Bitni linkovi</h4>
                                <div className="cm-footer__menu-container">
                                    <ul className="cm-footer__menu">
                                        <li className="cm-footer__menu-item"><a href="#">O nama</a></li>
                                        <li className="cm-footer__menu-item"><a href="#">Kontakt</a></li>
                                        <li className="cm-footer__menu-item"><a href="#">FAQ</a></li>
                                        <li className="cm-footer__menu-item"><a href="#">Autori</a></li>
                                        <li className="cm-footer__menu-item"><a href="#">Kursevi</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div className="cm-footer__col">
                                <h4>Kontakt info</h4>
                                <div className="cm-footer__contact-info">
                                    <ul>
                                        <li>
                                              <span className="cm-footer__contact-icon">
                                                <i className="fa fa-map-marker" aria-hidden="true"></i>
                                              </span>
                                            <span className="cm-footer__content">
                                            <span className="cm-footer__heading">Lokacija:</span>
                                            <span className="cm-footer__details"
                                            >Marka Markovića 23a, 11000 Beograd</span
                                            >
                                          </span>
                                        </li>
                                        <li>
                                          <span className="cm-footer__contact-icon">
                                            <i className="fa fa-phone" aria-hidden="true"></i>
                                          </span>
                                                                    <span className="cm-footer__content">
                                            <span className="cm-footer__heading">Telefon:</span>
                                            <span className="cm-footer__details">+381 011 322 543</span>
                                          </span>
                                        </li>
                                        <li>
                                          <span className="cm-footer__contact-icon">
                                            <i className="fa fa-paper-plane-o" aria-hidden="true"></i>
                                          </span>
                                                                    <span className="cm-footer__content">
                                            <span className="cm-footer__heading">Email:</span>
                                            <span className="cm-footer__details"
                                            >helpdesk@kursmania.rs</span
                                            >
                                          </span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div className="cm-footer__site-info">
                <p>© 2020, All Rights Reserved.</p>
            </div>
        </footer>

    );
}

export default Footer;