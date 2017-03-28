package com.epam.authorization.service;

import com.epam.authorization.domain.Account;

public interface AccountService {

	Account findByLogin(String login);
}