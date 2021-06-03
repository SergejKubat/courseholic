import axios from 'axios';

const CATEGORIES_API_URI = "http://localhost:8080/api/categories/";

class CategoryService {

    getAll() {
        return axios.get(CATEGORIES_API_URI);
    }
    
}

export default new CategoryService();