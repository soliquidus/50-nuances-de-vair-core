package dev.entity;

import javax.persistence.*;

@Table(name = "census", indexes = {
        @Index(name = "id_city_css", columnList = "id_city_css", unique = true)
})
@Entity
public class Census {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "population")
    private Long population;

    @Column(name = "id_city_css", nullable = false)
    private Long idCityCss;

    public Long getIdCityCss() {
        return idCityCss;
    }

    public void setIdCityCss(Long idCityCss) {
        this.idCityCss = idCityCss;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}