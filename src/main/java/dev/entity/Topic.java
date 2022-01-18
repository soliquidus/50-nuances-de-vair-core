package dev.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cipot")
public class Topic extends BaseEntity {

    @Column(name="title", nullable = false, length = 50)
    private String title;

    @Column(name="creation_date", nullable = false)
    private LocalDateTime creationDate;

    /**
     * Constructors
     */
    public Topic() {
    }

    public Topic(String title, LocalDateTime creationDate) {
        this.title = title;
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "title='" + title + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
