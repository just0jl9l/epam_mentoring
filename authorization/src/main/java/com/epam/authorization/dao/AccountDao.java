package com.epam.authorization.dao;

import com.epam.authorization.domain.Account;

public interface AccountDao {
	Account findByLogin(String login);
}
