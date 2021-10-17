package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Item itemUI = new Item();
        itemUI.getCreated();
        System.out.println(itemUI.getCreated());
        itemUI.getFormatter();
        System.out.println(itemUI.getFormatter());
    }
}
