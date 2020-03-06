package trabajopolis.entities;

public class Curriculum {
    private PersonalInformation personalInformation;
    private GeneralInformation generalInformation;
    private Education education;
    private ResumeExperience resumeExperience;

    public Curriculum() {
        personalInformation = new PersonalInformation();
        generalInformation = new GeneralInformation();
        education = new Education();
        resumeExperience = new ResumeExperience();
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public GeneralInformation getGeneralInformation() {
        return generalInformation;
    }

    public Education getEducation() {
        return education;
    }

    public ResumeExperience getResumeExperience() {
        return resumeExperience;
    }
}
