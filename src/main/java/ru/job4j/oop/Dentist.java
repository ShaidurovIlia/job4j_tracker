package ru.job4j.oop;

public class Dentist extends Doctor {

    private boolean social;

    private boolean caring;

    public Dentist(String name, String surname, String education,
                   int birthday, boolean positive, String direction, String pacient) {
        super(name, surname, education, birthday, positive, direction, pacient);
        this.social = social;
        this.caring = caring;
    }
}
