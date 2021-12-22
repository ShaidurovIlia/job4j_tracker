package ru.job4j.ex;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void compareUp() {
        Item first = new Item("Ilya");
        Item second = new Item("Tanya");
        Item three = new Item("Olga");
        List<Item> items = Arrays.asList(first, second, three);
        List<Item> expected = Arrays.asList(second, three, first);
        Collections.sort(items, new ItemDescByName());
        assertThat(items, is(expected));
    }

    @Test
    public void compareDown() {
        Item first = new Item("Ilya");
        Item second = new Item("Tanya");
        Item three = new Item("Olga");
        List<Item> items = Arrays.asList(first, second, three);
        List<Item> expected = Arrays.asList(first, three, second);
        Collections.sort(items, new ItemAscByName());
        assertThat(items, is(expected));
    }
}