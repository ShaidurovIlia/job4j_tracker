package ru.job4j.tracker;

public class Surgeon extends Doctor {

    private boolean excerpt;

    private String coldness;

    public Surgeon(String name, String surname, String education
            , int birthday, boolean positive, String direction) {
        super(name, surname, education, birthday, positive, direction);
         this.excerpt = excerpt;
         this.coldness = coldness;
    }

    @Override
    public String getEducation() {
        return super.getEducation();
    }
}
