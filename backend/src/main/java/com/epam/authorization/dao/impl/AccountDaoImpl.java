package com.epam.authorization.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.epam.authorization.dao.AccountDao;
import com.epam.authorization.domain.Account;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

	@PersistenceContext
	private EntityManager manager;

	private static final String SQL_SELECT_BY_LOGIN = "FROM Account WHERE login = :value1";
	private static final String SQL_SELECT_ALL = "FROM Account";

	@Override
	public Account findByLogin(String login) {
		return manager.createQuery(SQL_SELECT_BY_LOGIN, Account.class).setParameter("value1", login).getSingleResult();
	}

	@Override
	public Account findById(Integer id) {
		return manager.find(Account.class, id);
	}

	@Override
	public void save(Account account) {
		manager.persist(account);
	}

	@Override
	public void deleteById(Integer id) {
		manager.remove(manager.find(Account.class, id));

	}

	@Override
	public List<Account> findAllAccounts() {
		return manager.createQuery(SQL_SELECT_ALL, Account.class).getResultList();
	}

	@Override
	public void update(Account account) {
		manager.merge(account);

	}

}
