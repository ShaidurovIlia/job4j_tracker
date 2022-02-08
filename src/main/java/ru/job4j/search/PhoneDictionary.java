package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predName = (s) -> s.getName().equals(key);
        Predicate<Person> predSurName = (s) -> s.getSurname().equals(key);
        Predicate<Person> predPhone = (s) -> s.getPhone().equals(key);
        Predicate<Person> predAdress = (s) -> s.getAddress().equals(key);
        Predicate<Person> combine = predName.or(predSurName).or(predPhone).or(predAdress);
        ArrayList<Person> result = new ArrayList<>();
        for (var person: persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}