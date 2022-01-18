package dev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cirbur")
public class Rubric extends BaseEntite {

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    /**
     * Constructors
     */
    public Rubric() {
    }

    public Rubric(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Rubric{" +
                "name='" + name + '\'' +
                '}';
    }
}
