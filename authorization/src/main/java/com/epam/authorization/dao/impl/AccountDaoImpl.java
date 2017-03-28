package com.epam.authorization.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.epam.authorization.dao.AccountDao;
import com.epam.authorization.domain.Account;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

	@PersistenceContext
	private EntityManager manager;

	private static final String SQL_SELECT = "FROM Account WHERE login = :value1";

	@Override
	public Account findByLogin(String login) {
			return (Account) manager.createQuery(SQL_SELECT).setParameter("value1", login).getSingleResult();
	}

}
