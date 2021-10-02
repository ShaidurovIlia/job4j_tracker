package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        System.out.println(position);

        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
            if (position == 2) {
                System.out.println("Спокойной ночи");
            }else{
                System.out.println("Песня не найдена");
            }
        }
    }

    public static void main(String[] args) {
        Jukebox emma = new Jukebox();
        int song = 3;
        emma.music(song);
    }
}
