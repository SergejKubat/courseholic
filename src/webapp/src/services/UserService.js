import axios from 'axios';

const USERS_API_URI = 'http://localhost:8080/api/users';

class UserService {

    getUser(username) {
        return axios.get(`${USERS_API_URI}/${username}`);
    }

    getAllUsers() {
        return axios.get(USERS_API_URI);
    }

    uploadAvatar(username, data) {
        return axios.put(`${USERS_API_URI}/${username}/uploadAvatar`, data, { headers: { Authorization: 'Bearer ' + localStorage.getItem('token') } });
    }

}

export default new UserService();