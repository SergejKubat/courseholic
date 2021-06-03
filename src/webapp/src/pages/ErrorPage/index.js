import { NavLink } from "react-router-dom";

const ErrorPage = () => {
    return (
        <section class="cm-404">
            <div class="cm-404__container">
                    <div class="cm-404__content">
                    <h1 class="cm-404__heading">Ops! This page doesn't exist!</h1>
                    <h3 class="cm-404__desc">
                        Lorem ipsum, dolor sit amet consectetur adipisicing elit. Nihil ratione accusamus quas provident, minima fugit ipsa, mollitia nisi ut officia facere deserunt dicta recusandae qui alias non obcaecati unde laborum ipsum eligendi earum similique. Fugit, voluptate accusantium nulla quas corrupti molestiae eligendi debitis nesciunt vero est, omnis minima ullam ab!
                    </h3>
                    <NavLink exact to="/home">
                        <button class="cm-btn">Back to Home</button>
                    </NavLink>
                </div>
            </div>
        </section>
    );
}
 
export default ErrorPage;