package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void distanceMethod() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 4);
        double dist = a.distance(b);
        assertThat(dist, closeTo(4, 0.001));
    }

    @Test
    public void distanceMethodTwo() {
        Point a = new Point(3, 0);
        Point b = new Point(0, 0);
        double dist = a.distance(b);
        assertThat(dist, closeTo(3, 0.001));
    }

    @Test
    public void distanceMethodThree() {
        Point a = new Point(2, 0);
        Point b = new Point(0, 3);
        double dist = a.distance(b);
        assertThat(dist, closeTo(3.6, 0.01));
    }

    @Test
    public void distance3d2() {
        Point a = new Point(2, 1, 2);
        Point b = new Point(1, 3, 1);
        double dist = a.distance(b);
        assertThat(dist, closeTo(2.23, 0.01));
    }

    @Test
    public void distance3d4() {
        Point a = new Point(2, 1, 3);
        Point b = new Point(2, 3, 2);
        double dist = a.distance(b);
        assertThat(dist, closeTo(2, 0.001));
    }
}