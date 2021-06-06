import Lection from '../Lection';

import { AiOutlinePlus } from 'react-icons/ai';

const Section = (props) => {

    return (
        <div class="cm-course__content2-collapsible">
            <input
                type="checkbox"
                id={props.sectionDto.section.name}
                class="cm-course__content2-collapsible-checkbox"
            />
            <label for={props.sectionDto.section.name} class="cm-course__content2-collapsible-label">
                <div class="cm-course__content2-collapsible-header">
                <h1 class="cm-course__content2-collapsible-heading">{props.sectionDto.section.name}</h1>
                <AiOutlinePlus className="cm-course__content2-collapsible-icon" />
                </div>
            </label>
            <div class="cm-course__content2-collapsible-content">
                <ul class="cm-course__content2-collapsible-list">
                {props.sectionDto.lections.map(lection => (
                    <Lection
                    key={lection.id}
                    lection={lection} 
                    />
                ))}
                </ul>
            </div>
        </div>
    );
}
 
export default Section;