package dev.entity;

import javax.persistence.*;

@Entity
@Table(name = "rubric")
public class Rubric extends BaseEntity {
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_admin_rbc", nullable = false)
    private Admin idAdminRbc;

    public Admin getIdAdminRbc() {
        return idAdminRbc;
    }

    public void setIdAdminRbc(Admin idAdminRbc) {
        this.idAdminRbc = idAdminRbc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}