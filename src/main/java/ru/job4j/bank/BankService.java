package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        if (findByPassport(passport) != null) {
            User user = findByPassport(passport);
            List<Account> add = users.get(user);
            if (!add.contains(account)) {
                add.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User find : users.keySet()) {
            if (find.getPassport().equals(passport)) {
                rsl = find;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account findAcc = null;
        User findReq = findByPassport(passport);
        if (findReq != null) {
            List<Account> find = users.get(findReq);
            for (Account acc : find) {
                if (acc.getRequisite().equals(requisite)) {
                    findAcc = acc;
                }
            }
        }
        return findAcc;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account fromAc = findByRequisite(srcPassport, srcRequisite);
        Account toAc = findByRequisite(destPassport, destRequisite);
        if (fromAc != null && toAc != null && fromAc.getBalance() - amount >= 0) {
            fromAc.setBalance(fromAc.getBalance() - amount);
            toAc.setBalance(toAc.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
