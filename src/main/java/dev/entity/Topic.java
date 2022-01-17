package dev.entity;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "topic", indexes = {
        @Index(name = "id_user_tpc", columnList = "id_user_tpc"),
        @Index(name = "id_rubric_tpc", columnList = "id_rubric_tpc")
})
@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "creation_date", nullable = false)
    private Instant creationDate;

    @Column(name = "id_rubric_tpc", nullable = false)
    private Long idRubricTpc;

    @Column(name = "id_user_tpc", nullable = false)
    private Long idUserTpc;

    public Long getIdUserTpc() {
        return idUserTpc;
    }

    public void setIdUserTpc(Long idUserTpc) {
        this.idUserTpc = idUserTpc;
    }

    public Long getIdRubricTpc() {
        return idRubricTpc;
    }

    public void setIdRubricTpc(Long idRubricTpc) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}