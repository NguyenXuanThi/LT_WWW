package iuh.fit.se.bai2.daos;

import iuh.fit.se.bai2.entities.Account;

import java.util.List;

public interface AccountDAO {

    public Account save(Account account);

    public Account update(Account account);

    public boolean delete(int id);

    public Account findById(int id);

    public List<Account> findAll();

}
