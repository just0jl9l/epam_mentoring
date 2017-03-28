package com.epam.authorization.service;

import com.epam.authorization.domain.Account;
import com.epam.authorization.service.exception.DataNotFoundException;
import com.epam.authorization.service.exception.GettingDataException;
import com.epam.authorization.service.exception.WrongDataException;

public interface AccountService {

	Account authorization(String login, String password)
			throws WrongDataException, GettingDataException, DataNotFoundException;
}