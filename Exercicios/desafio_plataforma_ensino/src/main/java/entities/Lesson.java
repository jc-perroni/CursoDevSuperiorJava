package entities;

public abstract class Lesson {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Lesson(String title) {
        this.title = title;
    }
    public Lesson(){
    }
    public abstract int duration();
}
