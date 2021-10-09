package ru.job4j.oop;

public class Max {

    public static int max(int left, int right) {
        return left > right ? left : right;
    }

    public static int max(int left, int right, int third) {
        return max(left, right) > third ? max(left,right) : third;
    }

    public static int max(int left, int right, int third, int four) {
        return max( left, right, third) > four ? max(left, right, third) : four;
    }
}
