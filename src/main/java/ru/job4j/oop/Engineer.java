package ru.job4j.oop;

public class Engineer extends Profession {

    private boolean resolute;

    private String builder;

    public Engineer(String name, String surname, String education,
                    int birthday) {
        super(name, surname, education, birthday);

        this.resolute = resolute;
        this.builder = builder;
    }

    public Opening haw(Engineer engineer) {
        return new Opening();
    }
}
