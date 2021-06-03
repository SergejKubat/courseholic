const CourseCard = () => {
    return (
        <div class="cm-course-item">
            <div class="cm-course-item__thumbnail">
                <img
                src="sasasasa"
                alt="sasasa"
                class="cm-course-item__img"
                />
                <div class="cm-course-item__hidden">
                <button class="cm-btn">
                    Details
                </button>
                </div>
                <span class="cm-course-item__popular">Popularan</span>
                <span class="cm-course-item__price">$ 12</span>
                <span class="cm-course-item__rating">
                <span class="average">average rating</span>
                {/* <i class="fa fa-star" [ngClass]="{'active': countAverageMark() >= 1 ? true : false}" aria-hidden="true"></i>
                <i class="fa fa-star" [ngClass]="{'active': countAverageMark() >= 2 ? true : false}" aria-hidden="true"></i>
                <i class="fa fa-star" [ngClass]="{'active': countAverageMark() >= 3 ? true : false}" aria-hidden="true"></i>
                <i class="fa fa-star" [ngClass]="{'active': countAverageMark() >= 4 ? true : false}" aria-hidden="true"></i>
                <i class="fa fa-star" [ngClass]="{'active': countAverageMark() == 5 ? true : false}" aria-hidden="true"></i> */}
                <span class="count">rating count</span>
                </span>
            </div>
            <div class="cm-course-item__details">
                <h3>Course 1</h3>
                <div class="cm-course-item__info">
                <span>
                    <i class="fa fa-graduation-cap" aria-hidden="true"></i>
                    <a>Author</a>
                </span>
                <span>
                    {/* <i class="fa fa-users" aria-hidden="true"></i> */}
                    12
                </span>
                </div>
            </div>
        </div>
    );
}
 
export default CourseCard;