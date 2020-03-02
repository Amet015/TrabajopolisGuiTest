package Trabajopolis.entities;


public class Context {

    private Curriculum curriculum;

    public Context(){
        curriculum = new Curriculum();
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

}
