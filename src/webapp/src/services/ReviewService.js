import axios from 'axios';

const REVIEWS_API_URI = "http://localhost:8080/api";

class ReviewService {

    createReview(courseId, data) {
        return axios.post(`${REVIEWS_API_URI}/courses/${courseId}/reviews`, data, { headers: { Authorization: 'Bearer ' + localStorage.getItem('token') } });
    }

    getAllByUsername(username) {
        return axios.get(`${REVIEWS_API_URI}/users/${username}/reviews`);
    }
    
    deleteReview(reviewId) {
        return axios.delete(`${REVIEWS_API_URI}/reviews/${reviewId}`, { headers: { Authorization: 'Bearer ' + localStorage.getItem('token') } });
    }

}

export default new ReviewService();