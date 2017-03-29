package com.epam.authorization.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.epam.authorization.dao.AccountRoleDao;
import com.epam.authorization.domain.AccountRole;
import com.epam.authorization.domain.AccountRoleType;

@Repository("accountRoleDao")
public class AccountRoleDaoImpl implements AccountRoleDao {

	private static final String SQL_SELECT_ALL = "FROM AccountRole";
	private static final String SQL_SELECT_BY_LOGIN = "FROM AccountRole WHERE role = :value1";

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<AccountRole> findAll() {
		return manager.createQuery(SQL_SELECT_ALL, AccountRole.class).getResultList();
	}

	@Override
	public AccountRole findByType(AccountRoleType role) {
		return manager.createQuery(SQL_SELECT_BY_LOGIN, AccountRole.class).setParameter("value1", role)
				.getSingleResult();
	}

	@Override
	public AccountRole findById(Integer id) {
		return manager.find(AccountRole.class, id);
	}

}
