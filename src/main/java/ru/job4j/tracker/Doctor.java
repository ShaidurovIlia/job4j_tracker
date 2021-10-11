package ru.job4j.tracker;

public class Doctor extends Profession {

    private boolean positive;

    private  String direction;

public Doctor(String name, String surname, String education
        , int birthday, boolean positive, String direction) {
    super(name, surname, education, birthday);
    this.positive = positive;
    this.direction = direction;
}

    @Override
    public String getName() {
        return super.getName();
    }
}
