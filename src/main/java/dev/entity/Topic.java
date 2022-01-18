package dev.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "cn_topic")
public class Topic extends BaseEntity {

    @Column(length = 50)
    private String title;

    @Column
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(mappedBy = "topic")
    private List<Message> messages;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_rubric")
    private Rubric rubric;

    /**
     * Constructors
     */
    public Topic() {
    }

    public Topic(String title, LocalDateTime creationDate, User user, List<Message> messages, Rubric rubric) {
        this.title = title;
        this.creationDate = creationDate;
        this.user = user;
        this.messages = messages;
        this.rubric = rubric;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Rubric getRubric() {
        return rubric;
    }

    public void setRubric(Rubric rubric) {
        this.rubric = rubric;
    }
}
