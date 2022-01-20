package dev.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "cn_user")
public class User extends BaseEntity {
	
	
	@Column(nullable = false, length = 25)
	private String userName;
	
	@Column(nullable = false, length = 50)
	private String firstName;
	
	@Column(nullable = false, length = 50)
	private String lastName;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@Column(nullable = false, length = 50)
	private String password;
	
	private Boolean isAccountActive;
	
	private boolean isAdmin;

	@OneToMany(mappedBy = "user")
	private List<Message> messages;

	@Embedded
	private Address address;

	@ManyToMany
	@JoinTable(name="cn_favorite",
			joinColumns = @JoinColumn(name = "id_user" ),
			inverseJoinColumns =@JoinColumn(name = "id_city") )
	private List<City> cities;

	public User() {
	}

	

	public User(String userName, String firstName, String lastName, String email, String password,
			Boolean isAccountActive, Boolean isAdmin, List<Message> messages, Address address, List<City> cities) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.isAccountActive = isAccountActive;
		this.isAdmin = isAdmin;
		this.messages = messages;
		this.address = address;
		this.cities = cities;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsAccountActive() {
		return isAccountActive;
	}



	public void setIsAccountActive(Boolean isAccountActive) {
		this.isAccountActive = isAccountActive;
	}



	public Boolean getIsAdmin() {
		return isAdmin;
	}



	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
}
