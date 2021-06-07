import axios from 'axios';

const REVIEWS_API_URI = "http://localhost:8080/api/courses";

class ReviewService {

    createReview(courseId, data) {
        return axios.post(`${REVIEWS_API_URI}/${courseId}/reviews`, data);
    }

}

export default new ReviewService();