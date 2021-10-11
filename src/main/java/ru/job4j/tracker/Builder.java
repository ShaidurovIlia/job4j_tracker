package ru.job4j.tracker;

public class Builder extends  Engineer {
    private boolean strong;

    public Builder(String name, String surname, String education
            , int birthday) {
        super(name, surname, education, birthday);
        this.strong = strong;
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }
}
