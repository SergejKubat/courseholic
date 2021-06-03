const SignUpPage = () => {
    return (
        <section class="cm-registration">
            <div class="cm-registration__container">
                <div class="cm-registration__content">
                <h1 class="cm-registration__heading">Sign Up</h1>
                <form class="cm-registration__form">
                    <div class="cm-registration__control">
                    <label for="fullName" class="cm-registration__label">Name</label>
                    <input
                        type="text"
                        id="fullName"
                        name="name"
                        class="cm-registration__input"
                        required
                        autocomplete="off"
                        autocapitalize="off"
                    />
                    </div>
                    <div class="cm-registration__control">
                    <label for="email" class="cm-registration__label">Email</label>
                    <input
                        type="email"
                        id="email"
                        name="email"
                        class="cm-registration__input"
                        required
                    />
                    </div>
                    <div class="cm-registration__control">
                    <label for="password" class="cm-registration__label">Password</label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        class="cm-registration__input"
                        required
                        minlength="8"
                        maxlength="32"
                    />
                    </div>
                    <div class="cm-registration__control">
                    <input
                        type="checkbox"
                        name="terms"
                        id="terms"
                        class="cm-registration__checkbox"
                        required
                    />
                    <label for="terms" class="cm-registration__check-container">
                        <span class="cm-registration__checkmark" tabindex="0"></span>
                        I accept privacy policy.
                    </label>
                    </div>
                    <br />
                    <div class="cm-registration__control">
                        <button type="submit" class="cm-btn cm-registration__submit">
                            Sign Up
                        </button>
                    </div>
                </form>
                <p class="cm-registration__login">
                    Already have an account?
                    <a class="cm-registration__link">Sign In</a>
                </p>
                </div>
                </div>
            </section>
    );
}
 
export default SignUpPage;