import './assets/sass/app.scss'
import { BrowserRouter as Router, Route, Switch, Redirect} from 'react-router-dom';

// components
import ScrollToTop from './components/ScrollToTop';
import Header from './components/Header';
import Footer from './components/Footer';

//pages
import HomePage from './pages/HomePage';
import SignInPage from './pages/SignInPage';
import SignUpPage from './pages/SignUpPage';
import AuthorPage from './pages/AuthorPage';
import CoursePage from './pages/CoursePage';
import SearchPage from './pages/SearchPage';
import AccountPage from './pages/AccountPage';
import ErrorPage from './pages/ErrorPage';

function App() {
  return (
    <div>
      <Router>
        <Header />
        <ScrollToTop>
          <Switch>
              <Route exact path="/home" component={HomePage} />
              <Route exact path="/signin" component={SignInPage} />
              <Route exact path="/signup" component={SignUpPage} />
              <Route exact path="/author/:username" component={AuthorPage} />
              <Route exact path="/author/:username/courses/:courseId" component={CoursePage} />
              <Route exact path="/search" component={SearchPage} />
              <Route path="/account/:accountId" component={AccountPage} />
              <Route exact path="/" component={() => <Redirect to="/home" />} />
              <Route path="*" component={ErrorPage} />
          </Switch>
        </ScrollToTop>
        <Footer />
      </Router>
    </div>
  );
}

export default App;