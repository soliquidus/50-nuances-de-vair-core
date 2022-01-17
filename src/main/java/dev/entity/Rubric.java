package dev.entity;

import javax.persistence.*;

@Table(name = "rubric", indexes = {
        @Index(name = "id_admin", columnList = "id_admin_rbc")
})
@Entity
public class Rubric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "id_admin_rbc", nullable = false)
    private Long idAdminRbc;

    public Long getIdAdminRbc() {
        return idAdminRbc;
    }

    public void setIdAdminRbc(Long idAdminRbc) {
        this.idAdminRbc = idAdminRbc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}