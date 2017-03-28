package com.epam.authorization.service;

import java.util.List;

import com.epam.authorization.domain.Account;

public interface AccountService {

	Account findByLogin(String login);

	Account findById(Integer id);

	void save(Account a);

	void update(Account a);

	List<Account> findAll();

	void delete(Integer id);
}