import logo from '../../assets/img/logo-white.png';

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
                                            src={logo}
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
                                        <li className="cm-footer__menu-item"><span>About us</span></li>
                                        <li className="cm-footer__menu-item"><span>Contact</span></li>
                                        <li className="cm-footer__menu-item"><span>FAQ</span></li>
                                        <li className="cm-footer__menu-item"><span>Authors</span></li>
                                        <li className="cm-footer__menu-item"><span>Courses</span></li>
                                    </ul>
                                </div>
                            </div>
                            <div className="cm-footer__col">
                                <h4>Contact info</h4>
                                <div className="cm-footer__contact-info">
                                    <ul>
                                        <li>
                                            <span className="cm-footer__contact-icon">
                                                <i className="fa fa-map-marker" aria-hidden="true"></i>
                                            </span>
                                            <span className="cm-footer__content">
                                            <span className="cm-footer__heading">Lokacija:</span>
                                            <span className="cm-footer__details">Marka Markovića 23a, 11000 Belgrade</span>
                                          </span>
                                        </li>
                                        <li>
                                          <span className="cm-footer__contact-icon">
                                            <i className="fa fa-phone" aria-hidden="true"></i>
                                          </span>
                                            <span className="cm-footer__content">
                                            <span className="cm-footer__heading">Phone:</span>
                                            <span className="cm-footer__details">+381 011 322 543</span>
                                          </span>
                                        </li>
                                        <li>
                                          <span className="cm-footer__contact-icon">
                                            <i className="fa fa-paper-plane-o" aria-hidden="true"></i>
                                          </span>
                                            <span className="cm-footer__content">
                                            <span className="cm-footer__heading">Email:</span>
                                            <span className="cm-footer__details">courseholic@gmail.com</span>
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
                <p>© { new Date().getFullYear() }, All Rights Reserved.</p>
            </div>
        </footer>
    );
}

export default Footer;