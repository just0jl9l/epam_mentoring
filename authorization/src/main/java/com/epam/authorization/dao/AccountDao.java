package com.epam.authorization.dao;

import com.epam.authorization.dao.exception.DaoException;
import com.epam.authorization.domain.Account;

public interface AccountDao {
	Account get(String login, String password) throws DaoException;
}
