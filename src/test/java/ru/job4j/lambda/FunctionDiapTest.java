package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FunctionDiapTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result =
                FunctionDiap.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D,
                13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenQuadraticResults() {
        List<Double> result =
                FunctionDiap.diapason(3, 6, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(9D, 16D, 25D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenExponentionalResult() {
        List<Double> result =
                FunctionDiap.diapason(1, 4, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(2D, 4D, 8D);
        assertThat(result, is(expected));
    }
}