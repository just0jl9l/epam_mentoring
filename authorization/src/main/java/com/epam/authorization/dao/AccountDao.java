package com.epam.authorization.dao;

import java.util.List;

import com.epam.authorization.domain.Account;

public interface AccountDao {
	Account findByLogin(String login);

	Account findById(Integer id);

	void save(Account account);

	void update(Account account);

	void deleteById(Integer id);

	List<Account> findAllAccounts();
}
