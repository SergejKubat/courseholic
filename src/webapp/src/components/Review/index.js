const Review = () => {
    return (
        <li class="cm-course__reviews-comments-item">
            <div class="cm-course__reviews-comments-info">
                <div class="cm-course__reviews-comments-avatar">
                <img
                    src="aaa"
                    alt="aaaa"
                    class="cm-course__reviews-comments-img"
                />
                </div>
                <div class="cm-course__reviews-comments-details">
                <h4 class="cm-course__reviews-comments-name">User 1</h4>
                <div class="cm-course__reviews-comments-stars">
                    {/* <i aria-hidden="true" class="fa fa-star" [ngClass]="{'active': ocena.OCENA_VREDNOST >= 1 ? true : false}"></i>
                    <i aria-hidden="true" class="fa fa-star" [ngClass]="{'active': ocena.OCENA_VREDNOST >= 2 ? true : false}"></i>
                    <i aria-hidden="true" class="fa fa-star" [ngClass]="{'active': ocena.OCENA_VREDNOST >= 3 ? true : false}"></i>
                    <i aria-hidden="true" class="fa fa-star" [ngClass]="{'active': ocena.OCENA_VREDNOST >= 4 ? true : false}"></i>
                    <i aria-hidden="true" class="fa fa-star" [ngClass]="{'active': ocena.OCENA_VREDNOST == 5 ? true : false}"></i> */}
                </div>
                <p class="cm-course__reviews-comments-content">
                    Comment
                </p>
                <div class="cm-course__reviews-comments-actions">
                    <button class="cm-btn">Update</button>
                    <button class="cm-btn">Delete</button>
                </div>
                </div>
            </div>
        </li>
    );
}
 
export default Review;