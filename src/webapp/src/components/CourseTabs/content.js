import Section from '../Section';

const CourseContent = (props) => {
    return (
        <div className="cm-course__content2">
            <p className="cm-course__content2-heading">Course content</p>
            {props.sections.map(sectionDto => (
                <Section
                    key={sectionDto.section.id}
                    sectionDto={sectionDto}
                />
            ))}
        </div>
    );
}

export default CourseContent;