package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        return "Неизвестое слово." + eng;
    }

    public static void main(String[] args) {
        DummyDic cod = new DummyDic();
        String say = cod.engToRus("okey");
        System.out.println(say);

    }
}

