import { useState } from 'react';

import SearchService from '../../services/SearchService';

import { BsSearch } from 'react-icons/bs';
import { FaSearch } from 'react-icons/fa';
import { Link, useHistory } from 'react-router-dom';

const SearchBar = () => {

    const history = useHistory();

    const [results, setResults] = useState([]);
    const [showResults, setShowResult] = useState(false);

    const getResults = (query) => {
        if (!query) {
            setShowResult(false);
            return;
        };
        SearchService.getResults(encodeURI(query)).then(response => {
            setResults(response.data);
            setShowResult(true);
        });
    }

    const submitSearch = (event) => {
        event.preventDefault();
        const query = document.getElementById('q').value;
        setShowResult(false);
        history.push(`/search?query=${query}`);
    }

    return (
        <div className="cm-search">
            <form className="cm-search__form" onSubmit={(e) => submitSearch(e)}>
                <input
                    type="text"
                    name="q"
                    id="q"
                    placeholder="Search courses"
                    className="cm-search__input"
                    autoComplete="off"
                    onChange={(e) => getResults(e.target.value)}
                />
                <button className="cm-search__btn">
                    <BsSearch className="cm-search__btn" />
                </button>
            </form>

            {showResults && (
                <div className="cm-search__results" onClick={() => setShowResult(false)}>
                    <ul className="cm-search__list">
                        {results.map(result => (
                            <li className="cm-search__item">
                                <FaSearch />
                                <Link to={'/author/' + result.authorUsername + '/courses/' + result.courseId}>
                                    <span style={{ marginLeft: '.7rem' }}>{result.courseName}</span>
                                </Link>
                            </li>
                        ))}
                    </ul>
                </div>
            )}
        </div>
    );
}

export default SearchBar;