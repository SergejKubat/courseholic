import { useEffect, useState } from "react";
import { useParams } from "react-router";

import UserService from '../../services/UserService';

const AuthorPage = () => {

    const params = useParams();

    const [author, setAuthor] = useState({});

    useEffect(
        () => {
            UserService.getUser(params.username).then(response => {
                setAuthor(response.data);
            });
        },
        []
    );

    return (
        <section className="cm-author">
            <div className="cm-author__container">
                <img src={author.avatar} alt={author.username} className="cm-author__img" height="200" width="200" />
                <div className="cm-author__content">
                    <div className="cm-author__title">Author</div>
                    <h1 className="cm-author__heading">{author.firstName} {author.lastName}</h1>
                    <h2 className="cm-author__job">Software Engineer</h2>
                    <div className="cm-author__stats">
                    <div className="cm-author__stat">
                        <div className="cm-author__stat-title">Students</div>
                        <div className="cm-author__stat-count">123</div>
                    </div>
                    <div className="cm-author__stat">
                        <div className="cm-author__stat-title">Rating</div>
                        <div className="cm-author__stat-count">89</div>
                    </div>
                    </div>
                    <h2 className="cm-author__about-heading">About me</h2>
                    <p className="cm-author__about-text">Description</p>
                </div>

                <div className="cm-author__courses">
                    <h2 className="cm-author__courses-title">My courses (7)</h2>
                    <div className="cm-author__courses-list">
                    <div>
                        
                    </div>
                    </div>
                </div>
            </div>
        </section>
    );
}
 
export default AuthorPage;