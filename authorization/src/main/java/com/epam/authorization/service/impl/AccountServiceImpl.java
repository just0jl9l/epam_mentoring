package com.epam.authorization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.authorization.dao.AccountDao;
import com.epam.authorization.domain.Account;
import com.epam.authorization.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;

	@Override
	@Transactional
	public Account findByLogin(String login){
		Account account = null;
		if (login != null && !"".equals(login)) {
				account = accountDao.findByLogin(login);
				
		} 
		return account;
	}
}