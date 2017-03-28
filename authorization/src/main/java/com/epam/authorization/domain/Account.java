package com.epam.authorization.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account implements Serializable {

	private static final long serialVersionUID = -3096608053723881301L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(generator = "AccountSeq")
	@SequenceGenerator(name = "AccountSeq", sequenceName = "ACCOUNT_SEQ")
	private Integer id;

	@Column(name = "login", unique = true, nullable = false)
	private String login;

	@Column(name = "password", nullable = false)
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ACCOUNT_AND_ACCOUNT_ROLE", 
            joinColumns = { @JoinColumn(name = "ACCOUNT_ID") }, 
            inverseJoinColumns = { @JoinColumn(name = "ACCOUNT_ROLE_ID") })
	private Set<AccountRole> roles = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Set<AccountRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<AccountRole> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", login=" + login + ", password=" + password + ", role="  + "]";
	}
	
}