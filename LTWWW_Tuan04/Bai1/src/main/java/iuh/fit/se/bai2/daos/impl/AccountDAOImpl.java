package iuh.fit.se.bai2.daos.impl;

import iuh.fit.se.bai2.daos.AccountDAO;
import iuh.fit.se.bai2.entities.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class AccountDAOImpl implements AccountDAO {
    private EntityManager entityManager;
    public AccountDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Account save(Account account) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(account);
            transaction.commit();
            return account;
        } catch (Exception e) {
            e.printStackTrace();

            if(transaction!=null && transaction.isActive()) {
                transaction.rollback();
            }
        }

        return null;
    }

    @Override
    public Account update(Account account) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(account);
            transaction.commit();
            return account;
        } catch (Exception e) {
            e.printStackTrace();

            if(transaction!=null && transaction.isActive()) {
                transaction.rollback();
            }
        }

        return null;
    }

    @Override
    public boolean delete(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Account account = entityManager.find(Account.class, id);
            if (account != null) {
                entityManager.remove(account);
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction!=null && transaction.isActive()) {
                transaction.rollback();
            }
        }
        return false;
    }

    @Override
    public Account findById(int id) {
        try {
            Account account = entityManager.find(Account.class, id);
            return account;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> findAll() {
        try {
            return entityManager
                    .createQuery("SELECT u FROM Account u", Account.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

