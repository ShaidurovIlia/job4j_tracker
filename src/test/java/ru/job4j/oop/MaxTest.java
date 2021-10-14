package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void maxThree() {
        assertThat(Max.max(2, 4, 1), is(4));
    }

    @Test
    public void maxFive() {
        assertThat(Max.max(1, 5, 2, 3), is(5));
    }

    @Test
    public void maxSeven() {
        assertThat(Max.max(4, 1, 2, 7), is(7));
    }
}