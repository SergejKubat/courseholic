import axios from 'axios';

const API_URI = "http://localhost:8080/api";

class PurchaseRecordService {

    getAllByUsername(username) {
        return axios.get(`${API_URI}/users/${username}/records`);
    }

    createPurchaseRecord(courseId) {
        return axios.post(`${API_URI}/courses/${courseId}/records`, {}, { headers: { Authorization: `Bearer ${localStorage.getItem('token')}` } });
    }

}

export default new PurchaseRecordService();