package dev.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "cn_category")
public class Category extends BaseEntity {

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_admin")
    private Admin admin;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Rubric> rubrics;

    public Category(){
    }

    public Category(String name, Admin admin, List<Rubric> rubrics) {
        this.name = name;
        this.admin = admin;
        this.rubrics = rubrics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Rubric> getRubrics() {
        return rubrics;
    }

    public void setRubrics(List<Rubric> rubrics) {
        this.rubrics = rubrics;
    }
}
