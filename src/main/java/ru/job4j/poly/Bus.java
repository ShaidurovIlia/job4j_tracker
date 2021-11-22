package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Маршрут 401");
    }

    @Override
    public void passenger(int psr) {
        System.out.println("В автобусе: " + psr + "пассажиров");
    }

    @Override
    public int price(int fuelUp) {
        return fuelUp * price(11);
    }
}
