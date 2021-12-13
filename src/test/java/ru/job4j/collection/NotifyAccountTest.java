package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.HashSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentiev", "eDer23321f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                new Account("123", "Petr Arsentiev", "eDer23321f"),
                new Account("142", "Petr Arsentev", "000001")
                )
        );
       assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void sentTwo() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Ilia Shaidurov", "eDer23321f"),
                new Account("142", "Petr Arsentev", "000001"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Ilia Shaidurov", "eDer23321f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}