const CategoryCard = (props) => {
    return (
        <div class="cm-categories-item" tabindex="0">
            <img
                src={props.image}
                alt={props.name}
                class="cm-categories-img"
            />
            <div class="cm-categories-desc">
                <h4>{props.name}</h4>
                <p>14</p>
            </div>
        </div>
    );
}
 
export default CategoryCard;