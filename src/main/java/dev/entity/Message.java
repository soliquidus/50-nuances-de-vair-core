package dev.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "message")
public class Message extends BaseEntity {
    @Column(name = "content", nullable = false, length = 1500)
    private String content;

    @Column(name = "post_time", nullable = false)
    private LocalDate postTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_topic_msg", nullable = false)
    private Topic idTopicMsg;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_user_msg", nullable = false)
    private User idUserMsg;

    public User getIdUserMsg() {
        return idUserMsg;
    }

    public void setIdUserMsg(User idUserMsg) {
        this.idUserMsg = idUserMsg;
    }

    public Topic getIdTopicMsg() {
        return idTopicMsg;
    }

    public void setIdTopicMsg(Topic idTopicMsg) {
        this.idTopicMsg = idTopicMsg;
    }

    public LocalDate getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDate postTime) {
        this.postTime = postTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}