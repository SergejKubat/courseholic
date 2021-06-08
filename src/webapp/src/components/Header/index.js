import { useEffect, useState } from 'react';
import Favicon from './../../assets/img/favicon.png';
import { Link, NavLink, useHistory } from 'react-router-dom';

import SearchBar from './../SearchBar';

import CategoryService from '../../services/CategoryService';
import AuthService from '../../services/AuthService';

import { FiShoppingCart } from 'react-icons/fi';
import { FaAngleDown } from 'react-icons/fa';

function Header() {

    const history = useHistory();

    const [categories, setCategories] = useState([]);

    useEffect(
        () => {
            CategoryService.getAll().then(response => {
                setCategories(response.data);
            });
        },
        []
    );

    const logOut = () => {
        history.push('/home');
        window.location.reload();
    }

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
                        <FaAngleDown style={{ marginLeft: '.5rem' }} />
                    </button>
                    <div className="cm-categories__hidden">
                        <ul className="cm-categories__list">
                            {categories.map(category => (
                                <li key={category.id} className="cm-categories__item">
                                    <NavLink to="/search/categories">
                                        {category.name}
                                    </NavLink>
                                </li>
                            ))}
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
                        <p>
                            {!AuthService.isAuthenticated() && (
                                <NavLink to="/signin">
                                    Sign In
                                </NavLink>
                            )}
                            </p>
                        </div>
                    </div>
                    {!AuthService.isAuthenticated() && (
                        <NavLink exact to="/signin">
                            <button className="cm-btn">Sign In</button>
                        </NavLink>
                    )}
                    {!AuthService.isAuthenticated() && (
                        <NavLink exact to="/signup">
                            <button className="cm-btn">Sign Up</button>
                        </NavLink>
                    )}
                    {AuthService.isAuthenticated() && (
                        <Link to="/account">
                            <img 
                            src={AuthService.getCurrentUser().avatar}
                            alt={AuthService.getCurrentUser().username} 
                            className="cm-user__avatar" 
                            />
                        </Link>
                    )}
                    {AuthService.isAuthenticated() && (
                        <button className="cm-btn" onClick={() => AuthService.signOut(logOut)}>
                            Log Out
                        </button>
                    )}
                </div>

                <div className="cm-navigation">
                    <input
                        type="checkbox"
                        id="menu"
                        className="cm-navigation__checkbox"
                    />
                    <label htmlFor="menu" className="cm-navigation__label">
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
                                    placeholder="Search courses"
                                    className="cm-search__input-small"
                                    autoComplete="off"
                                    required
                                />
                                </form>
                            </li>
                            <li className="cm-navigation__item">
                                <NavLink exact to="/home">Home</NavLink>
                            </li>
                            {AuthService.isAuthenticated() && (
                                <li className="cm-navigation__item">
                                    <Link to="/account" className="cm-navigation__flex">
                                        <img
                                            src={AuthService.getCurrentUser().avatar}
                                            alt={AuthService.getCurrentUser().username}
                                            className="cm-user__avatar-small"
                                        />
                                        <span className="cm-user__name">{AuthService.getCurrentUser().username}</span>
                                    </Link>
                                </li>
                            )}
                            <li className="cm-navigation__item">
                                <input
                                type="checkbox"
                                id="sub-menu"
                                className="cm-navigation__checkbox"
                                checked
                                onChange={() => console.log('changed')}
                                />
                                <label htmlFor="sub-menu" className="cm-navigation__label">
                                    Categories
                                    <FaAngleDown style={{ marginLeft: '.5rem' }} />
                                </label>
                                <ul className="cm-navigation__sub-list">
                                    {categories.map(category => (
                                        <li className="cm-navigation__sub-item">
                                            {category.name}
                                        </li>
                                    ))}
                                </ul>
                            </li>
                            {!AuthService.isAuthenticated() && (
                                <li className="cm-navigation__item">
                                    <NavLink exact to="/signin">
                                        Sign In
                                    </NavLink>
                                </li>
                            )}
                            {!AuthService.isAuthenticated() && (
                                <li className="cm-navigation__item">
                                    <NavLink exact to="/signup">
                                        Sign Up
                                    </NavLink>
                                </li>
                            )}
                        </ul>
                    </div>
                </div>

            </div>
        </header>
    );
}

export default Header;