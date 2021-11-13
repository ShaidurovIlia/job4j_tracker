package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int c) {
        return x - c;
    }

    public double divide(double d) {
        return x / d;
    }

    public double sumAllOperation(double f) {
        return sum(2) + multiply(5)
                + minus(4) + divide(2);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.multiply(5));
        System.out.println(sum(10));
        System.out.println(minus(4));
        System.out.println(calculator.divide(2));
        System.out.println(calculator.sumAllOperation(2));
       }
}
