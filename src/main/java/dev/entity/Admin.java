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

	@OneToMany(mappedBy = "admin")
	private List<Category> categories;

	public Admin() {
		super();
	}

	public Admin(List<Rubric> rubrics, List<Category> categories) {
		this.rubrics = rubrics;
		this.categories = categories;
	}

	public Admin(String userName, String firstName, String lastName, String email, String password, Boolean isAccountActive,
			boolean isAdmin,
			List<Message> messages, Address address, List<City> cities, List<Rubric> rubrics, List<Category> categories) {
		super(userName, firstName, lastName, email, password, isAccountActive, isAdmin, messages, address, cities);
		this.rubrics = rubrics;
		this.categories = categories;
	}

	public List<Rubric> getRubrics() {
		return rubrics;
	}

	public void setRubrics(List<Rubric> rubrics) {
		this.rubrics = rubrics;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
