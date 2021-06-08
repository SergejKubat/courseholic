import axios from 'axios';

const AUTH_API_URI = 'http://localhost:8080/api/auth';

class AuthService {

    signUp(data) {
        return axios.post(`${AUTH_API_URI}/signup`, data);
    }

    signIn(data, callback) {
        axios.post(`${AUTH_API_URI}/signin`, data).then(response => {
            if (response.status === 200) {
                const token = response.data.accessToken;
                localStorage.setItem('token', token);
                axios.get(`${AUTH_API_URI}/details`, { headers: { Authorization: 'Bearer ' + token } }).then(response => {
                    const userDetails = response.data;
                    localStorage.setItem('user', JSON.stringify(userDetails));
                    this.authenticated = true;
                    callback(true);
                });
            }
        }).catch(error => {
            callback(false);
        });
    }

    signOut(callback) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        callback();
    }

    getCurrentUser() {
        return JSON.parse(localStorage.getItem('user'));
    }

    setCurrentUser(userDetails) {
        localStorage.setItem('user', JSON.stringify(userDetails));
    }

    isAuthenticated() {
        return localStorage.getItem('token') != null;
    }

}

export default new AuthService();