package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public void show() {
        System.out.println(this.name + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void givNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.givNick("gav ");
        gav.show();
        System.out.println("There are black's food");
        Cat black = new Cat();
        black.eat("fish");
        black.givNick("black ");
        black.show();
    }
}
