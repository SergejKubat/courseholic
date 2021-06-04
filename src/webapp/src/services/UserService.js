import axios from 'axios';

const USERS_API_URI = 'http://localhost:8080/api/users';

class UserService {

    getUser(username) {
        return axios.get(`${USERS_API_URI}/${username}`);
    }

    getAllUsers() {
        return axios.get(USERS_API_URI);
    }

}

export default new UserService();