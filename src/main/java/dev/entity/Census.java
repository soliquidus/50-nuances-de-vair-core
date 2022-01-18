package dev.entity;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.*;

@Entity
@Table(name = "cn_census")
public class Census extends BaseEntity {
	
	@Column(length = 20)
    private BigInteger population;

    public Census() {
    }

    public Census(BigInteger population) {
        this.population = population;
    }

    public BigInteger getPopulation() {
        return population;
    }

    public void setPopulation(BigInteger population) {
        this.population = population;
    }
}
