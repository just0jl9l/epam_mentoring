package com.epam.authorization.domain;

import java.io.Serializable;

public enum AccountRoleType implements Serializable{
	ROLE_USER("USER"),
	ROLE_ADMIN("ADMIN");
	
	String accountRoleType;
	
	private AccountRoleType(String accountRoleType){
		this.accountRoleType = accountRoleType;
	}
	
	public String getAccountRoleType(){
		return accountRoleType;
	}
	
}
