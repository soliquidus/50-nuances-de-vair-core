package dev.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cn_rubric")
public class Rubric extends BaseEntity {

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_admin")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @OneToMany(mappedBy = "rubric", cascade = CascadeType.REMOVE)
    private List<Topic> topics;

    public Rubric() {
    }

    public Rubric(String name, Admin admin, List<Topic> topics, Category category) {
        this.name = name;
        this.admin = admin;
        this.topics = topics;
        this.category = category;
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

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}
