package ru.job4j.oop;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + ": Летает по воздуху");
    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName() + ": Скорость 800 км/ч");
    }
}
