import { useEffect, useState } from "react";
import AuthService from '../../services/AuthService';

import { ToastContainer, toast } from 'react-toastify';

const { Link, useLocation, useHistory, Redirect } = require("react-router-dom");

const SignInPage = () => {

    const history = useHistory();

    const query = new URLSearchParams(useLocation().search);

    const notify = (firstName, lastName) => {
        toast.success(`Congratulations ${firstName} ${lastName}, you have successfully registered. Please sign in now!`, {
            style: {fontSize: '1.6rem'},
            draggable: false,
            autoClose: 5000,
            position: toast.POSITION.TOP_CENTER
        });
    }

    useEffect(
        () => {
            if (query.get('signedUpSuccessfully') === 'true' && query.get('firstName') && query.get('lastName')) {
                notify(query.get('firstName'), query.get('lastName'));
            }
        },
        []
    )

    const [signInError, setSignInError] = useState(false);
    const [signInErrorMessage, setSignInErrorMessage] = useState("");

    const singIn = (e) => {
        e.preventDefault();

        const usernameOrEmail = document.getElementById('usernameOrEmail').value.trim();
        const password = document.getElementById('password').value.trim();

        const data = {
            usernameOrEmail: usernameOrEmail,
            password: password
        }

        AuthService.signIn(data, afterSignIn);
    }

    const afterSignIn = (isAuthenticated) => {
        if (isAuthenticated) {
            history.push('/account');
            window.location.reload();
        } else {
            setSignInError(true);
            setSignInErrorMessage('Bad credentials.');
        }
    }

    if (AuthService.isAuthenticated()) {
        return <Redirect to="/account" />;
    }

    return (
        <section className="cm-login">

            <ToastContainer />

            <div className="cm-login__container">

                <div className="cm-login__content">
                    <h1 className="cm-login__heading">Sign In</h1>
                    <form className="cm-login__form" onSubmit={(e) => singIn(e)}>
                        <div className="cm-login__control">
                            <label htmlFor="usernameOrEmail" className="cm-login__label">Username or Email</label>
                            <input
                                type="text"
                                id="usernameOrEmail"
                                name="usernameOrEmail"
                                className="cm-login__input"
                                required
                            />
                        </div>
                        <div className="cm-login__control">
                            <label htmlFor="password" className="cm-login__label">Password</label>
                            <input
                                type="password"
                                id="password"
                                name="password"
                                className="cm-login__input"
                                required
                                minLength="6"
                            />
                        </div>
                        <div className="cm-login__control">
                            <input
                                type="checkbox"
                                name="remember"
                                id="remember"
                                className="cm-login__checkbox"
                            />
                            <label htmlFor="remember" className="cm-login__check-container">
                                <span className="cm-login__checkmark" tabIndex="0"></span>
                                Stay sign in
                            </label>
                        </div>
                        <div className="cm-login__control">
                        <button type="submit" className="cm-btn cm-login__submit">
                            Sign In
                        </button>
                        </div>
                    </form>
                    <div className="cm-registration__error-signup">
                        {signInError && <div>{signInErrorMessage}</div>}
                    </div>
                    <p className="cm-login__login">
                        Don't have an account?
                        <br />
                        <Link to="/signup" className="cm-login__link">
                             Sign up
                        </Link>
                    </p>
                    <p className="cm-login__login">
                        <Link to="/home" className="cm-login__link">
                            Forgotten password?
                        </Link>
                    </p>
                </div>
            </div>
        </section>
    );
}
 
export default SignInPage;