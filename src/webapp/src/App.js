import './assets/sass/app.scss'
import { BrowserRouter as Router, Route, Switch, Redirect} from 'react-router-dom';

// components
import Header from './components/Header';
import Footer from './components/Footer';

//pages
import Home from './pages/Home';
import SignIn from './pages/SignIn';
import SignUp from './pages/SignUp';

function App() {
  return (
    <div>
      <Router>
        <Header />
          <Switch>
            <Route exact path="/home" component={Home} />
            <Route exact path="/signin" component={SignIn} />
            <Route exact path="/signup" component={SignUp} />
            <Route exact path="/" component={() => <Redirect to="/home" />} />
          </Switch>
        <Footer />
      </Router>
    </div>
  );
}

export default App;