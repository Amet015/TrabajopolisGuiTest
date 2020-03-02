package Trabajopolis.entities;


public class Context {
//    private PersonalInformation personalInformation;
//    private ResumeExperience resumeExperience;
//    private Education education;
//    private GeneralInformation generalInformation;
    private Curriculum curriculum;

    public Context(){
        curriculum = new Curriculum();
    }
//

    public Curriculum getCurriculum() {
        return curriculum;
    }

//    public PersonalInformation getPersonalInformation(){
//        return personalInformation;
//    }
//
//    public ResumeExperience getResumeExperience() {
//        return resumeExperience;
//    }
//
//    public Education getEducation(){
//        return education;
//    }
//
//    public GeneralInformation getGeneralInformation() {
//        return generalInformation;
//    }
}
