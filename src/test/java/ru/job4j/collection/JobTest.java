package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenComparatorAscName() {
        List<Job> comp = Arrays.asList(new Job("Ivan", 1), new Job("Roma", 2));
        Collections.sort(comp, new JobAscByName());
        Iterator<Job> iter = comp.iterator();
        assertThat(iter.next(), is(new Job("Ivan", 1)));
        assertThat(iter.next(), is(new Job("Roma", 2)));
    }

    @Test
    public void whenComparatorDescName() {
        List<Job> comp = Arrays.asList(new Job("Ivan", 1), new Job("Roma", 2));
        Collections.sort(comp, new JobDescByName());
        Iterator<Job> iter = comp.iterator();
        assertThat(iter.next(), is(new Job("Roma", 2)));
        assertThat(iter.next(), is(new Job("Ivan", 1)));
    }

    @Test
    public void whenComparatorAscPriority() {
        List<Job> comp = Arrays.asList(new Job("Ivan", 1), new Job("Roma", 2));
        Collections.sort(comp, new JobAscByName());
        Iterator<Job> iter = comp.iterator();
        assertThat(iter.next(), is(new Job("Ivan", 1)));
        assertThat(iter.next(), is(new Job("Roma", 2)));
    }

    @Test
    public void whenComparatorDescPriority() {
        List<Job> comp = Arrays.asList(new Job("Ivan", 1), new Job("Roma", 2));
        Collections.sort(comp, new JobDescByName());
        Iterator<Job> iter = comp.iterator();
        assertThat(iter.next(), is(new Job("Roma", 2)));
        assertThat(iter.next(), is(new Job("Ivan", 1)));
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix Bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix Bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriorityEquallyNameAscPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriorityEquallyNameDownPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriorityEquallAll() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 0)
        );
        assertThat(rsl, is(0));
    }
}