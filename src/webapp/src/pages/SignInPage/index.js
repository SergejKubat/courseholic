const SignInPage = () => {
    return (
        <section class="cm-login">
            <div class="cm-login__container">
                <div class="cm-login__content">
                <h1 class="cm-login__heading">Sign In</h1>
                <form class="cm-login__form">
                    <div class="cm-login__control">
                    <label for="email" class="cm-login__label">Username or email</label>
                    <input
                        type="text"
                        id="email"
                        name="email"
                        class="cm-login__input"
                        required
                    />
                    </div>
                    <div class="cm-login__error">You have to provide username or email</div>
                    <div class="cm-login__control">
                    <label for="password" class="cm-login__label">Password</label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        class="cm-login__input"
                        required
                        minlength="8"
                        maxlength="32"
                    />
                    </div>
                    <div class="cm-login__error">You have to provide password</div>
                    {/* <div class="cm-login__error">Dužina lozinke mora biti minimum 8 slova.</div>
                    <div class="cm-login__error">Dužina lozinke mora biti maksimum 32 slova.</div> */}
                    <div class="cm-login__control">
                    <input
                        type="checkbox"
                        name="remember"
                        id="remember"
                        class="cm-login__checkbox"
                    />
                    <label for="remember" class="cm-login__check-container">
                        <span class="cm-login__checkmark" tabindex="0"></span>
                        Stay sign in
                    </label>
                    </div>
                    <div class="cm-login__control">
                    <button type="submit" class="cm-btn cm-login__submit">
                        Sign In
                    </button>
                    </div>
                </form>
                <p class="cm-login__login">
                    You don't have account?
                    <a class="cm-login__link">Sign up</a>
                </p>
                <p class="cm-login__login">
                    <a class="cm-login__link">Forgotten password?</a>
                </p>
                </div>
            </div>
        </section>
    );
}
 
export default SignInPage;