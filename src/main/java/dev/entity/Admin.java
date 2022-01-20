package dev.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "cn_admin")
public class Admin extends User {

	
	
	@OneToMany(mappedBy = "admin")
	private List<Rubric> rubrics;

	public Admin() {
		super();
	}


	public Admin(String userName, String firstName, String lastName, String email, String password,
			Boolean isAccountActive, List<Message> messages, Address address, List<City> cities, List<Rubric> rubrics) {
		super(userName, firstName, lastName, email, password, isAccountActive, messages, address, cities);
		this.rubrics = rubrics;
	}


	public List<Rubric> getRubrics() {
		return rubrics;
	}

	public void setRubrics(List<Rubric> rubrics) {
		this.rubrics = rubrics;
	}
}
