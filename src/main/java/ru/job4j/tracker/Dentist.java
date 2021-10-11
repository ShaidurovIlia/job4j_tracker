package ru.job4j.tracker;

public class Dentist extends Doctor {

    private boolean social;

    private boolean caring;

    public Dentist(String name, String surname, String education
            , int birthday, boolean positive, String direction) {
        super(name, surname, education, birthday, positive, direction);
        this.social = social;
        this.caring = caring;
    }
}
