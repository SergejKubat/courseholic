import axios from 'axios';

const API_URI = "http://localhost:8080/api";

class PurchaseRecordService {

    getAllByUsername(username) {
        return axios.get(`${API_URI}/users/${username}/records`);
    }

}

export default new PurchaseRecordService();