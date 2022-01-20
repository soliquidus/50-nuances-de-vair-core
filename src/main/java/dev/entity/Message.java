package dev.entity;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "cn_message")
public class Message extends BaseEntity {

    @Column(nullable = false, length = 1500)
    private String content;

    @Column(nullable = false)
    private LocalDateTime postTime;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "id_topic")
    private Topic topic;

    /**
     * Constructors
     */
    public Message() {
    }

    public Message(String content, LocalDateTime postTime, User user, Topic topic) {
        this.content = content;
        this.postTime = postTime;
        this.user = user;
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
