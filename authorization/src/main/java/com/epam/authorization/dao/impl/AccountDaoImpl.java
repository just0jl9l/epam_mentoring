package com.epam.authorization.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.epam.authorization.dao.AccountDao;
import com.epam.authorization.dao.exception.DaoException;
import com.epam.authorization.domain.Account;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

	@PersistenceContext
	private EntityManager manager;

	private static final String SQL_SELECT = "FROM Account WHERE Login = :value1;";

	@Override
	public Account findByLogin(String login) throws DaoException {
		try {
			return manager.createQuery(SQL_SELECT, Account.class).setParameter("value1", login).getSingleResult();
		} catch (DataAccessException e) {
			throw new DaoException("Exception occurred during authorization", e);
		}
	}

}
