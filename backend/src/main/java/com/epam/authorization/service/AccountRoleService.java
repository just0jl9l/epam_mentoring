package com.epam.authorization.service;

import java.util.List;

import com.epam.authorization.domain.AccountRole;
import com.epam.authorization.domain.AccountRoleType;

public interface AccountRoleService {
	List<AccountRole> findAll();

	AccountRole findByType(AccountRoleType role);

	AccountRole findById(Integer id);
}
