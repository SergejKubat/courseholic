import Favicon from './../../assets/img/favicon.png';
import { NavLink } from 'react-router-dom';

import SearchBar from './../SearchBar';

import { FiShoppingCart } from 'react-icons/fi';

function Header() {
    return (
        <header>
            <div className="cm-header__top">

                <div className="cm-logo">
                    <NavLink exact to="/home">
                        <img
                            src={Favicon}
                            alt="Courseholic Logo"
                            className="cm-logo__img"
                        />
                    </NavLink>
                    <h1 className="cm-logo__text">Courseholic</h1>
                </div>

                <div style={{ flex: "0 0 60%" }}>
                    <SearchBar />
                </div>

                <nav className="cm-categories">
                    <button className="cm-categories__btn">
                        Categories
                        <i className="fa fa-angle-down" aria-hidden="true"></i>
                    </button>
                    <div className="cm-categories__hidden">
                        <ul className="cm-categories__list">
                        <li className="cm-categories__item">
                        </li>
                        </ul>
                    </div>
                </nav>

                <div className="cm-user">
                    <div className="cm-user__card">
                        <div className="cm-user__card--container">
                            <FiShoppingCart style={{ width: '2rem', height: '2rem' }} />
                        </div>
                        <div className="cm-user__card--content">
                        <p>Your cart is empty.</p>
                        <p>Sign In</p>
                        </div>
                    </div>
                    <NavLink exact to="/signin">
                        <button className="cm-btn">Sign In</button>
                    </NavLink>
                    <NavLink exact to="/signup">
                        <button className="cm-btn">Sign Up</button>
                    </NavLink>
                    {/* <a>
                        <img
                        src="avatar"
                        alt=""
                        className="cm-user__avatar"
                        />
                    </a> */}
                    <button className="cm-btn">
                        Log Out
                    </button>
                </div>

                <div className="cm-navigation">
                    <input
                        type="checkbox"
                        id="menu"
                        className="cm-navigation__checkbox"
                    />
                    <label for="menu" className="cm-navigation__label">
                        <div className="cm-navigation__button">
                        <span className="cm-navigation__icon"></span>
                        </div>
                    </label>
                    <div className="cm-navigation__items">
                        <ul className="cm-navigation__list">
                        <li className="cm-navigation__item">
                            <form className="cm-search__form-small">
                            <input
                                type="text"
                                name="q"
                                placeholder="Pretražite kurseve"
                                value=""
                                className="cm-search__input-small"
                                autoComplete="off"
                                required
                            />
                            </form>
                        </li>
                        <li className="cm-navigation__item">
                            <NavLink exact to="/home">Home</NavLink>
                        </li>
                        <li className="cm-navigation__item">
                            <a className="cm-navigation__flex">
                            <img
                                src="bla"
                                alt=""
                                className="cm-user__avatar-small"
                            />
                            <span className="cm-user__name">username</span>
                            </a>
                        </li>
                        <li className="cm-navigation__item">
                            <input
                            type="checkbox"
                            id="sub-menu"
                            className="cm-navigation__checkbox"
                            checked
                            />
                            <label for="sub-menu" className="cm-navigation__label">
                            Kategorije
                            <i
                                className="fa fa-angle-down cm-navigation__angle"
                                aria-hidden="true"
                            ></i>
                            </label>
                            <ul className="cm-navigation__sub-list">
                            <li
                                className="cm-navigation__sub-item">
                                
                            </li>
                            </ul>
                        </li>
                        <li className="cm-navigation__item">
                            <NavLink exact to="/signin">Sign In</NavLink>
                        </li>
                        <li className="cm-navigation__item">
                            <NavLink exact to="/signup">Sign Up</NavLink>
                        </li>
                        </ul>
                    </div>
                    </div>

            </div>
        </header>
    );
}

export default Header;