package ru.job4j.bank;

import java.util.*;

/**
 * Класс  является хранилищем пользователей и их данных.
 * А так же описывает операции производимые с моделями данных.
 * @author Ilya Shaidurov
 * @version 1.0
 */
public class BankService {
    /**
     * Данные хранятся в коллекции тима HashMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает пользователя, если он отсутсвует в списке,
     * его добавляют в коллекцию.
     * @param user пользователь, который добавлятся в список.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод находит пользователя по паспортым данным, если его находит,
     * то добавляет ему счет.
     * @param passport паспортные данные пользователя.
     * @param account добавляемый счет.
     */
    public void addAccount(String passport, Account account) {
       Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> add = users.get(user.get());
            if (!add.contains(account)) {
                add.add(account);
            }
        }
    }

    /**
     * Метод поиска пользователя по паспортым данным.
     * @param passport паспортные данные пользователя, которого нужно найти.
     * @return найденный пользователь.Если пользователя нет, возвращает пустой список.
     */

    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет пользователя по паспортым данным и реквизитам.
     * Если пользователь найден,то метод возвращает его счет, иначе -
     * пустой список.
     * @param passport паспортные данные пользователя.
     * @param requisite реквизиты счета, которые нужно найти.
     * @return счет найденного пользователя.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> findReg = findByPassport(passport);
        if (findReg.isPresent()) {
            return users.get(findReg.get())
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Метод осуществляет перевод денежных средств с одного счета на другой,
     * если оба счета найдены и хватает средств на счете клиента осуществляющего перевод.
     * @param srcPassport паспортные данные пользователя списываемого счета.
     * @param srcRequisite реквизиты счета, откуда списываются средства.
     * @param destPassport паспортные данные пользователя на счет которого переводят средства.
     * @param destRequisite реквизиты счета, куда переводят средства.
     * @param amount сумма перевода.
     * @return если перевод выполнен получаем - true, иначе - false.
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> fromAc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> toAc = findByRequisite(destPassport, destRequisite);
        if (fromAc.isPresent() && toAc.isPresent() && fromAc.get().getBalance() >= amount) {
            fromAc.get().setBalance(fromAc.get().getBalance() - amount);
            toAc.get().setBalance(toAc.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
