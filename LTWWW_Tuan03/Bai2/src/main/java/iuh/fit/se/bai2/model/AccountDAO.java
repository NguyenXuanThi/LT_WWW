package iuh.fit.se.bai2.model;

import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    private final List<Account> accountList = new ArrayList<Account>();

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
