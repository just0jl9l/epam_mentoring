package com.epam.authorization.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.authorization.dao.AccountRoleDao;
import com.epam.authorization.domain.AccountRole;
import com.epam.authorization.domain.AccountRoleType;
import com.epam.authorization.service.AccountRoleService;

public class AccountRoleServiceImpl implements AccountRoleService {

	@Autowired
	private AccountRoleDao accountRoleDao;

	@Override
	public List<AccountRole> findAll() {
		return accountRoleDao.findAll();
	}

	@Override
	public AccountRole findByType(AccountRoleType role) {
		AccountRole accountRole = null;
		if (role != null) {
			accountRole = accountRoleDao.findByType(role);
		}
		return accountRole;
	}

	@Override
	public AccountRole findById(Integer id) {
		AccountRole accountRole = null;
		if (id != null) {
			accountRole = accountRoleDao.findById(id);
		}
		return accountRole;
	}
}