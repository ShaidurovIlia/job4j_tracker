package ru.job4j.bank;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("2323", "Ilya Shaidurov");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("2323").get(), is(user));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("2323", "Ilya Shaidurov");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("4422", 234D));
        assertThat(bank.findByRequisite("21", "4422"), is(Optional.empty()));
    }

    @Test
    public void addAccount() {
        User user = new User("2323", "Ilya Shaidurov");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("4422", 234D));
        assertThat(bank.findByRequisite("2323", "4422").get().getBalance(), is(234D));
    }

    @Test
    public void transferMoney() {
        User user = new User("2323", "Ilya Shaidurov");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("4422", 234D));
        bank.addAccount(user.getPassport(), new Account("50", 10D));
        bank.transferMoney(user.getPassport(), "4422",
                user.getPassport(), "50", 100D);
        assertThat(bank.findByRequisite(user.getPassport(), "50").get().getBalance(), is(110D));
    }

    @Test
    public void transferNotFindAccount() {
        User user = new User("2323", "Ilya Shaidurov");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("4422", 234D));
        bank.addAccount(user.getPassport(), new Account("50", 10D));
        assertFalse(bank.transferMoney(user.getPassport(), "4422",
                user.getPassport(), "60", 234D));
    }

    @Test
    public void transferNotFindAccountSecond() {
        User user = new User("2323", "Ilya Shaidurov");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("4422", 234D));
        bank.addAccount(user.getPassport(), new Account("50", 10D));
        assertFalse(bank.transferMoney(user.getPassport(), "4423",
                user.getPassport(), "50", 234D));
    }

    @Test
    public void add2Accounts() {
        User user = new User("2323", "Ilya Shaidurov");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("1111", 234D));
        bank.addAccount(user.getPassport(), new Account("1122", 300D));
        assertThat(bank.findByRequisite("2323", "1122").get().getBalance(), is(300D));
    }
}