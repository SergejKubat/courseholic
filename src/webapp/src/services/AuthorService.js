import axios from 'axios';

const AUTHORS_API_URI = 'http://localhost:8080/api/authors';

class AuthorService {

    getByUsername(username) {
        return axios.get(`${AUTHORS_API_URI}/${username}`);
    }

    getAll() {
        return axios.get(AUTHORS_API_URI);
    }

}

export default new AuthorService();