import { Redirect, Route } from 'react-router-dom';
import AuthService from '../services/AuthService';

const ProtectedRoute = ({ component: Commponent, ...rest }) => {
    return (
        <Route {...rest} render={
            (props) => {
                if (AuthService.isAuthenticated()) {
                    return <Commponent {...props} />
                }
                else {
                    return <Redirect to={
                        {
                            pathname: '/signin',
                            state: {
                                from: props.location
                            }
                        }
                    } />
                }
            }
        }/>
    );
}
 
export default ProtectedRoute;