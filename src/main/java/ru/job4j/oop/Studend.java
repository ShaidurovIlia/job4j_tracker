package ru.job4j.oop;

public class Studend {

    public  void music() {
        System.out.println("Tra tra tra");
    }
    public void song() {
        System.out.println("I believe I can fly");
    }

    public static void main(String[] args) {
        Studend petya = new Studend();
        petya.music();
        petya.music();
        petya.music();
        petya.song();
        petya.song();
        petya.song();
    }
}
