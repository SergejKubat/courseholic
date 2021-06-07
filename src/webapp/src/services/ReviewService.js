import axios from 'axios';

const REVIEWS_API_URI = "http://localhost:8080/api";

class ReviewService {

    createReview(courseId, data) {
        return axios.post(`${REVIEWS_API_URI}/courses/${courseId}/reviews`, data);
    }

    getAllByUsername(username) {
        return axios.get(`${REVIEWS_API_URI}/users/${username}/reviews`);
    }

}

export default new ReviewService();