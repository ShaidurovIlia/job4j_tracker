package ru.job4j.oop;

public class Doctor extends Profession {

    private boolean positive;

    private  String direction;

    private  String pacient;

    public Doctor(String name, String surname, String education,
                  int birthday, boolean positive, String direction, String pacient) {
        super(name, surname, education, birthday);
        this.positive = positive;
        this.direction = direction;
    }

    private  Diagnosis heal(Pacient pacient) {
        return new Diagnosis();
    }
}
