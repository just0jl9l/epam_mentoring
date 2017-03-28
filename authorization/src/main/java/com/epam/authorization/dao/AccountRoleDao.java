package com.epam.authorization.dao;

import java.util.List;

import com.epam.authorization.domain.AccountRole;
import com.epam.authorization.domain.AccountRoleType;

public interface AccountRoleDao {
	List<AccountRole> findAll();

	AccountRole findByType(AccountRoleType role);

	AccountRole findById(Integer id);
}
