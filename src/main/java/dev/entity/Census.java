package dev.entity;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "census")
public class Census extends BaseEntity {
	
	@Column(name = "population", nullable = false, length = 20)
    private BigDecimal population;
	
}
