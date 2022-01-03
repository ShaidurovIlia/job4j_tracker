package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс  содержит описание банковского счета, который состоит
 * из полей : баланс и реквезиты.
 * @author Ilya Shaidurov
 * @version 1.0
 */
public class Account {
    /**
     * Банковский счет характеризуется балансом и реквезитами.
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор класса Account инициализирует переменные :
     * @param requisite при создании объекта записываются его реквизиты.
     * @param balance при создании объекта записывается баланс банковского счета.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод осуществляет доступ к приватному полю.
     * @return возвращает реквизиты объекта.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод записывает реквизиты объекта.
     * @param requisite реквизиты банковского счета.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод осуществляет доступ к приватному полю.
     * @return возвращает баланс.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Записывает баланс на банковский счет.
     * @param balance баланс банковского счета.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределяет метод equals для корректного сравнения объектов.
     * Принимает на вход объект с которым идет сравнение и объект
     * для которого вызывается метод. Сравнение происходит по реквизитам.
     * @param o принимает на вход объект.
     * @return возвращает возвращает булево значение. Если объекты равны - tru,
     * иначе - false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределяет метод hashCode для корректного сравнения объектов.
     * @return возвращает чисто, которое является хеш - кодом объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
