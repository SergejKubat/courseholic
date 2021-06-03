const ReviewList = () => {
    return (
        <div class="cm-course__reviews-comments">
            <h3 class="cm-course__reviews-heading">Reviews</h3>
            <ul class="cm-course__reviews-comments-list">
                <div>
                {/* <app-review [ocena]="ocena" (deleteReviewEvent)="removeOcena($event)"></app-review> */}
                </div>
            </ul>
            <div>
                {/* <app-create-review [kurs]="kurs" (newReviewEvent)="addOcena($event)"></app-create-review> */}
            </div>
        </div>
    );
}
 
export default ReviewList;