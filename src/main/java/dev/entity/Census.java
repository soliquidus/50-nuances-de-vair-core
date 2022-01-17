package dev.entity;

import javax.persistence.*;

@Entity
@Table(name = "census")
public class Census extends BaseEntity {
    @Column(name = "population")
    private Long population;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_city_css", nullable = false)
    private City idCityCss;

    public City getIdCityCss() {
        return idCityCss;
    }

    public void setIdCityCss(City idCityCss) {
        this.idCityCss = idCityCss;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }
}