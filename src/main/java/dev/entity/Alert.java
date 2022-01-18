package dev.entity;

import javax.persistence.*;

@Entity
@Table(name = "alert")
public class Alert extends BaseEntite {
	
	@Column(name = "message", nullable = false, length = 255)
    private String message;
	
}
