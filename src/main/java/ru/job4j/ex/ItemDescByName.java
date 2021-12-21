package ru.job4j.ex;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class ItemDescByName implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }
}
