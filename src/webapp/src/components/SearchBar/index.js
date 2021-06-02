import { BsSearch } from 'react-icons/bs';

const SearchBar = () => {
    return (
        <div className="cm-search">
            <form className="cm-search__form">
                <input
                type="text"
                name="q"
                placeholder="Search courses"
                className="cm-search__input"
                autoComplete="off"
                />
                <button className="cm-search__btn">
                    <BsSearch className="cm-search__btn" />
                </button>
            </form>
            <div className="cm-search__results" style={{ display: 'none' }}>
                <ul className="cm-search__list">
                <li className="cm-search__item">
                    <a>
                    <i className="fa fa-search" aria-hidden="true"></i>
                    </a>
                    <a>
                    <i className="fa fa-search" aria-hidden="true"></i>
                    </a>
                </li>
                </ul>
            </div>
        </div>
    );
}
 
export default SearchBar;