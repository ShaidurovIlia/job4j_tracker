package ru.job4j.oop;

public class Surgeon extends Doctor {

    private boolean excerpt;

    private String coldness;

    public Surgeon(String name, String surname, String education,
                   int birthday, boolean positive,
                   String direction, String pacient) {
        super(name, surname, education, birthday, positive, direction, pacient);
        this.excerpt = excerpt;
        this.coldness = coldness;
    }
}