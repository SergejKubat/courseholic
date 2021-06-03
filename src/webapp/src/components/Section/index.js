const Section = () => {
    return (
        <div class="cm-course__content2-collapsible">
            <input
                type="checkbox"
                id="{{ sekcija.SEKCIJA_NASLOV }}"
                class="cm-course__content2-collapsible-checkbox"
            />
            <label for="{{ sekcija.SEKCIJA_NASLOV }}" class="cm-course__content2-collapsible-label">
                <div class="cm-course__content2-collapsible-header">
                <h1 class="cm-course__content2-collapsible-heading">Section 1</h1>
                <i
                    class="fa fa-plus cm-course__content2-collapsible-icon"
                    aria-hidden="true"
                ></i>
                </div>
            </label>
            <div class="cm-course__content2-collapsible-content">
                <ul class="cm-course__content2-collapsible-list">
                {/* <div *ngFor="let lekcija of lekcije">
                        <app-lesson [lekcija]="lekcija"></app-lesson>
                    </div> */}
                </ul>
            </div>
        </div>
    );
}
 
export default Section;