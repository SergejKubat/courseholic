import { useState } from "react";
import AuthService from '../../services/AuthService';

const { Link, useHistory } = require("react-router-dom")

const SignUpPage = () => {

    const history = useHistory();

    const [termsError, setTermsError] = useState(false);
    const [signUpError, setSignUpError] = useState(false);
    const [signUpErrorMessage, setSignUpErrorMessage] = useState("");

    const signUp = (event) => {
        event.preventDefault();
        
        const firstName = document.getElementById('firstName').value.trim();
        const lastName = document.getElementById('lastName').value.trim();
        const username = document.getElementById('username').value.trim();
        const email = document.getElementById('email').value.trim();
        const password = document.getElementById('password').value.trim();
        const terms = document.getElementById('terms').checked;

        if (!terms) {
            setTermsError(true);
            return;
        }
        setTermsError(false);

        const data = {
            firstName: firstName,
            lastName: lastName,
            username: username,
            email: email,
            password: password,
            type: 'STUDENT'
        }

        AuthService.signUp(data).then(response => {
            const statusCode = response.status;
            if (statusCode === 200) {
                history.push('/signin');
            }
        }).catch(error => {
            setSignUpError(true);
            setSignUpErrorMessage(error.response.data);
        });
    }

    return (
        <section className="cm-registration">
            <div className="cm-registration__container">
                <div className="cm-registration__content">
                <h1 className="cm-registration__heading">Sign Up</h1>
                <form className="cm-registration__form" onSubmit={(e) => signUp(e)}>
                    <div className="cm-registration__control">
                        <label htmlFor="firstName" className="cm-registration__label">First name</label>
                        <input
                            type="text"
                            id="firstName"
                            name="firstName"
                            className="cm-registration__input"
                            required
                            autoComplete="off"
                            autoCapitalize="off"
                        />
                    </div>
                    <div className="cm-registration__control">
                        <label htmlFor="lastName" className="cm-registration__label">Last name</label>
                        <input
                            type="text"
                            id="lastName"
                            name="lastName"
                            className="cm-registration__input"
                            required
                            autoComplete="off"
                            autoCapitalize="off"
                        />
                    </div>
                    <div className="cm-registration__control">
                        <label htmlFor="username" className="cm-registration__label">Username</label>
                        <input
                            type="text"
                            id="username"
                            name="username"
                            className="cm-registration__input"
                            required
                            minLength="3"
                            autoComplete="off"
                            autoCapitalize="off"
                        />
                    </div>
                    <div className="cm-registration__control">
                        <label htmlFor="email" className="cm-registration__label">Email</label>
                        <input
                            type="email"
                            id="email"
                            name="email"
                            className="cm-registration__input"
                            required
                        />
                    </div>
                    <div className="cm-registration__control">
                        <label htmlFor="password" className="cm-registration__label">Password</label>
                        <input
                            type="password"
                            id="password"
                            name="password"
                            className="cm-registration__input"
                            required
                            minLength="6"
                        />
                    </div>
                    <div className="cm-registration__control">
                        <input
                            type="checkbox"
                            name="terms"
                            id="terms"
                            className="cm-registration__checkbox"
                        />
                        <label htmlFor="terms" className="cm-registration__check-container">
                            <span className="cm-registration__checkmark" tabIndex="0"></span>
                            I accept privacy policy.
                        </label>
                    </div>
                    {termsError && <div className="cm-registration__error">You must accept terms.</div>}
                    <br />
                    <div className="cm-registration__control">
                        <button type="submit" className="cm-btn cm-registration__submit">
                            Sign Up
                        </button>
                    </div>
                </form>
                <div className="cm-registration__error-signup">
                    {signUpError && <div>{signUpErrorMessage}</div>}
                </div>
                <p className="cm-registration__login">
                    Already have an account?
                    <br />
                    <Link to="/signin" className="cm-registration__link">Sign In</Link>
                </p>
                </div>
                </div>
            </section>
    );
}
 
export default SignUpPage;