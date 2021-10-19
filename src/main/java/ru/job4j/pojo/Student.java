package ru.job4j.pojo;

public class Student {
    private String lastname;
    private String name;
    private  String patronymic;
    private String group;
    private String ofReceipt;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getOfReceipt() {
        return ofReceipt;
    }

    public void setOfReceipt(String ofReceipt) {
        this.ofReceipt = ofReceipt;
    }
}
