package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {

    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        var result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenHigherSecondPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("Low", 3));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 2));
        queue.take();
        var result = queue.take();
        assertThat(result.getDesc(), is("middle"));
    }

    @Test
    public void whenHigherTwoPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("Low", 3));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 2));
        queue.take();
        queue.take();
        var result = queue.take();
        assertThat(result.getDesc(), is("Low"));
    }
}