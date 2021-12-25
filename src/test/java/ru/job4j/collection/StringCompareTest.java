package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class StringCompareTest {

    @Test
    public void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rsl, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void stringNull() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "",
                ""
        );
        assertThat(rsl, is(0));
    }

    @Test
    public void stringOnlyNumbersEqual() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "12345",
                "12345"
        );
        assertThat(rsl, is(0));
    }

    @Test
    public void stringOnlyNumbersUnequal() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "12345",
                "431"
        );
        assertThat(rsl, lessThan(0));
    }
}