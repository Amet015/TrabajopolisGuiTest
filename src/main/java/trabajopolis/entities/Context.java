package trabajopolis.entities;


public class Context {

    private Curriculum curriculum;
    private SearchJob searchJob;
    private EditProfile editProfile;
    private PopUp popUp;

    public Context() {
        curriculum = new Curriculum();
        searchJob = new SearchJob();
        editProfile = new EditProfile();
        popUp = new PopUp();
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public SearchJob getSearchJob() {
        return searchJob;
    }

    public PopUp getPopUp() {
        return popUp;
    }

    public EditProfile getEditProfile() {
        return editProfile;
    }

}
