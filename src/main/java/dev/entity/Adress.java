package dev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sserda")
public class Adress extends BaseEntity {
	
	@Column(nullable = false, length = 50)
	private String streetName;
	
	@Column(nullable = false, length = 15)
	private String number;
	
	@Column(nullable = false, length = 50)
	private String complement;
	
	

	public Adress() {
	}

	public Adress(String streetName, String number, String complement) {
		this.streetName = streetName;
		this.number = number;
		this.complement = complement;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}
	
	
	

}
