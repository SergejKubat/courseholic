const CreateReview = () => {
    return (
        <div class="cm-course__reviews-create">
            <h1>Your rating:</h1>
            <div class="cm-course__reviews-create-stars">
                {/* <i aria-hidden="true" class="fa fa-star" data-value="1" (click)="setMarkValue($event)"></i>
                <i aria-hidden="true" class="fa fa-star" data-value="2" (click)="setMarkValue($event)"></i>
                <i aria-hidden="true" class="fa fa-star" data-value="3" (click)="setMarkValue($event)"></i>
                <i aria-hidden="true" class="fa fa-star" data-value="4" (click)="setMarkValue($event)"></i>
                <i aria-hidden="true" class="fa fa-star" data-value="5" (click)="setMarkValue($event)"></i> */}
            </div>
            <div class="cm-course__reviews-create-error">You must enter rating</div>
            <div class="cm-course__reviews-create-content">
                <form class="cm-course__reviews-create-form">
                <div class="cm-course__reviews-create-form-control">
                    <label for="comment" class="cm-course__reviews-create-form-label">Comment:</label>
                    <textarea
                        name="comment"
                        id="comment"
                        class="cm-course__reviews-create-form-textarea"
                        cols="30"
                        rows="8"
                        placeholder="Unesite komentar"
                        minlength="10"
                        maxlength="1000"
                        required
                    ></textarea>
                </div>
                <div class="cm-course__reviews-create-error">Morate uneti komentar.</div>
                <div class="cm-course__reviews-create-error">Dužina komentara može biti minimum 10 karaktera.</div>
                <div class="cm-course__reviews-create-error">Dužina komentara može biti maksimum 1000 karaktera.</div>
                <div class="cm-course__reviews-create-form-submit">
                    <button type="submit" class="cm-btn">Pošalji</button>
                </div>
                </form>
            </div>
        </div>
    );
}
 
export default CreateReview;