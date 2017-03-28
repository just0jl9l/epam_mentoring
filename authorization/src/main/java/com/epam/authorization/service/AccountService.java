package com.epam.authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.authorization.dao.AccountDao;
import com.epam.authorization.dao.exception.DaoException;
import com.epam.authorization.domain.Account;
import com.epam.authorization.service.exception.DataNotFoundException;
import com.epam.authorization.service.exception.GettingDataException;
import com.epam.authorization.service.exception.WrongDataException;

@Service("accountService")
public class AccountService {
	
	@Autowired
	private AccountDao accountDao;

	@Transactional
	public Account authorization(String login, String password)
			throws WrongDataException, GettingDataException, DataNotFoundException {
		if (login != null && password != null && !"".equals(login) && !"".equals(password)) {
			try {
				Account account = accountDao.get(login, password);
				if (account != null) {
					return account;
				} else {
					throw new DataNotFoundException("Account wasn't found");
				}
			} catch (DaoException e) {
				throw new GettingDataException("DaoException occurred during getting account", e);
			}
		} else {
			throw new WrongDataException("Empty parameters");
		}
	}
}