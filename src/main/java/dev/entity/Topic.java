package dev.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "topic")
public class Topic extends BaseEntity {
    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "creation_date", nullable = false)
    private Instant creationDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_rubric_tpc", nullable = false)
    private Rubric idRubricTpc;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_user_tpc", nullable = false)
    private User idUserTpc;

    public User getIdUserTpc() {
        return idUserTpc;
    }

    public void setIdUserTpc(User idUserTpc) {
        this.idUserTpc = idUserTpc;
    }

    public Rubric getIdRubricTpc() {
        return idRubricTpc;
    }

    public void setIdRubricTpc(Rubric idRubricTpc) {
        this.idRubricTpc = idRubricTpc;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}