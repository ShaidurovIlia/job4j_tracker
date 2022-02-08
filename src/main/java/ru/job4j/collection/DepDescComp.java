package ru.job4j.collection;


import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String firstSlash01 = o1.split("/")[0];
        String firstSlash02 = o2.split("/")[0];
        int rsl = firstSlash02.compareTo(firstSlash01);
        return rsl == 0 ? o1.compareTo(o2) : rsl;
    }
}
