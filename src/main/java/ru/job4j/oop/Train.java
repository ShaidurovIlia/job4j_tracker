package ru.job4j.oop;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + ": Передвигается по рельсам");
    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName() + ": Скорость 60 км/ч");
    }
}
