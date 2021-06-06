import axios from 'axios';

const COURSES_AUTHOR_API_URI = "http://localhost:8080/api/users";
const COURSES_API_URI = "http://localhost:8080/api/courses";

class CourseService {

    getCoursesByAuthorUsername(username) {
        return axios.get(`${COURSES_AUTHOR_API_URI}/${username}/courses`);
    }

    getAllCourses() {
        return axios.get(`${COURSES_API_URI}`);
    }

    getCoursesByCategoryId(categoryId) {
        return axios.get(`${COURSES_API_URI}?categoryId=${categoryId}`);
    }

    getCourseById(username, courseId) {
        return axios.get(`${COURSES_AUTHOR_API_URI}/${username}/courses/${courseId}`);
    }

}

export default new CourseService();