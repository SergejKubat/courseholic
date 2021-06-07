import axios from 'axios';

const AUTH_API_URI = 'http://localhost:8080/api/auth';

class AuthService {

    signUp(data) {
        return axios.post(`${AUTH_API_URI}/signup`, data);
    }

    signIn(data) {

    }

}

export default new AuthService();