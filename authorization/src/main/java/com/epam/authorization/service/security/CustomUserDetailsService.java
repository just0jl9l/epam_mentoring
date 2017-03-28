package com.epam.authorization.service.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.authorization.domain.Account;
import com.epam.authorization.domain.AccountRole;
import com.epam.authorization.service.AccountService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private AccountService accountService;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Account account;
		account = accountService.findByLogin(login);
		if (account == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(account.getLogin(), account.getPassword(), true,
				true, true, true, getGrantedAuthorities(account));
	}

	private List<GrantedAuthority> getGrantedAuthorities(Account account) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (AccountRole role : account.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getRole().toString()));
		}
		return authorities;
	}

}
