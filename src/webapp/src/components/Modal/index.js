import { FaTimes } from 'react-icons/fa';
import { Link } from 'react-router-dom';

const Modal = (props) => {
    return (
        <div class="cm-modal">
            <div class="cm-modal__error">
                <div class="cm-modal__error-close">
                    <FaTimes onClick={() => props.closeMethod(false)} />
                </div>
                <h1 class="cm-modal__error-heading">{props.heading}</h1>
                <p class="cm-modal__error-paragraph">{props.message}</p>
                <Link to={props.btnLink}>
                    <button class="cm-btn">{props.btnText}</button>
                </Link>
                <button class="cm-btn" onClick={() => props.closeMethod(false)}>Leave</button>
            </div>
        </div>
    );
}

export default Modal;