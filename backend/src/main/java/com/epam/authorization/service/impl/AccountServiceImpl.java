package com.epam.authorization.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.authorization.dao.AccountDao;
import com.epam.authorization.domain.Account;
import com.epam.authorization.service.AccountService;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Override
	public Account findByLogin(String login) {
		Account account = null;
		if (login != null && !"".equals(login)) {
			account = accountDao.findByLogin(login);

		}
		return account;
	}

	@Override
	public Account findById(Integer id) {
		Account account = null;
		if (id != null) {
			account = accountDao.findById(id);

		}
		return account;
	}

	@Override
	public void save(Account a) {
		if (a != null) {
			accountDao.save(a);
		}
	}

	@Override
	public void update(Account a) {
		if (a != null && a.getId()!=null) {
			accountDao.update(a);
		}
		
	}

	@Override
	public List<Account> findAll() {
		return accountDao.findAllAccounts();
	}

	@Override
	public void delete(Integer id) {
		if (id != null) {
			accountDao.deleteById(id);

		}
	}
}