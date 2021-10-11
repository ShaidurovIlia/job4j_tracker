package ru.job4j.tracker;

public class Programmer extends Engineer {
    private boolean structural;
    private boolean calm;

    public Programmer(String name, String surname, String education
            , int birthday) {
        super(name, surname, education, birthday);
        this.structural = structural;
        this.calm = calm;
    }

    @Override
    public int getBirthday() {
        return super.getBirthday();
    }
}
