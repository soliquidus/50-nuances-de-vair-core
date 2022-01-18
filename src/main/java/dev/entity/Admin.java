package dev.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "elbat")
public class Admin extends User {

	public Admin(String userName, String firstName, String lastName, String email, String password,
			Boolean activeAccount) {
		super(userName, firstName, lastName, email, password, activeAccount);
		// TODO Auto-generated constructor stub
	}

}
