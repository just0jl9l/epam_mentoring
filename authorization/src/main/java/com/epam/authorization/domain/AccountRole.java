package com.epam.authorization.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "account_role")
public class AccountRole {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(generator = "AccountRoleSeq")
	@SequenceGenerator(name = "AccountRoleSeq", sequenceName = "ACCOUNT_ROLE_SEQ")
	private Integer id;

	@Column(name = "role", nullable = false)
	private AccountRoleType role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AccountRoleType getRole() {
		return role;
	}

	public void setRole(AccountRoleType role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		AccountRole other = (AccountRole) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountRole [id=" + id + ", role=" + role + "]";
	}

}
