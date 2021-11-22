package ru.job4j.oop;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + ": Двигается по скоростным трассам");
    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName() + ": Скорость 80 км/ч");
    }
}
