import axios from 'axios';

const SEARCH_API_URI = 'http://localhost:8080/api/search?query=';

class SearchService {

    getResults(query) {
        return axios.get(`${SEARCH_API_URI}${query}`);
    }

}

export default new SearchService();