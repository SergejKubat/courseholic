import { useState } from 'react';
import { AiFillPlayCircle } from 'react-icons/ai';
import { FaAngleDown, FaAngleUp } from 'react-icons/fa';

const Lection = (props) => {

    const [isCollapsed, setIsCollapsed] = useState(false);

    const toggleCollapse = () => {
        if (isCollapsed) {
            setIsCollapsed(false);
            return;
        }
        setIsCollapsed(true);
    }

    return (
        <li className="cm-course__content2-collapsible-item">
            <div className="cm-course__content2-collapsible-video" onClick={() => toggleCollapse()}>
                <div>
                    <AiFillPlayCircle className="cm-course__content2-collapsible-video-play" />
                    <p className="cm-course__content2-collapsible-video-name">{props.lection.name}</p>
                </div>
                <div className="cm-course__content2-collapsible-video-right">
                    <p className="cm-course__content2-collapsible-video-length">{props.lection.length}</p>
                    {!isCollapsed && <FaAngleDown className="cm-course__content2-collapsible-video-icons" />}
                    {isCollapsed && <FaAngleUp className="cm-course__content2-collapsible-video-icons" />}
                </div>
            </div>
            {isCollapsed && (
                <div className="cm-course__content2-collapsible-video-desc">
                    {props.lection.description}
                </div>
            )}
        </li>
    );
}
 
export default Lection;