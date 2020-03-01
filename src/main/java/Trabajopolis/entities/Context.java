package Trabajopolis.entities;

import Trabajopolis.entities.Education;
import Trabajopolis.entities.GeneralInformation;
import Trabajopolis.entities.PersonalInformation;
import Trabajopolis.entities.ResumeExperience;

public class Context {
    private PersonalInformation personalInformation;
    private ResumeExperience resumeExperience;
    private Education education;
    private GeneralInformation generalInformation;


    public Context(){
        personalInformation = new PersonalInformation();
        resumeExperience = new ResumeExperience();
        education = new Education();
        generalInformation = new GeneralInformation();
    }

    public PersonalInformation getPersonalInformation(){
        return personalInformation;
    }

    public ResumeExperience getResumeExperience() {
        return resumeExperience;
    }

    public Education getEducation(){
        return education;
    }

    public GeneralInformation getGeneralInformation() {
        return generalInformation;
    }
}
