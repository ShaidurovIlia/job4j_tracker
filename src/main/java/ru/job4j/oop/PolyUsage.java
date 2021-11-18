package ru.job4j.oop;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();

        Vehicle[] vehicle = new Vehicle[] {plane, train, bus};
        for (Vehicle m : vehicle) {
            m.move();
        }
    }
}
