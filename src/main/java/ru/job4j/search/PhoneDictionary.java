package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> person = new ArrayList<Person>();

    public void add(Person person) {
        this.person.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person pers : person) {
            if (pers.getName().contains(key) || pers.getSurname().contains(key)
                    || pers.getPhone().contains(key) || pers.getAddress().contains(key)) {
                result.add(pers);
            }
        }
        return result;
    }
}