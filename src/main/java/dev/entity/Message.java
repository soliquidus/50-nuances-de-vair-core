package dev.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "message", indexes = {
        @Index(name = "id_topic_msg", columnList = "id_topic_msg"),
        @Index(name = "id_user_msg", columnList = "id_user_msg")
})
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "content", nullable = false, length = 1500)
    private String content;

    @Column(name = "post_time", nullable = false)
    private LocalDate postTime;

    @Column(name = "id_topic_msg", nullable = false)
    private Long idTopicMsg;

    @Column(name = "id_user_msg", nullable = false)
    private Long idUserMsg;

    public Long getIdUserMsg() {
        return idUserMsg;
    }

    public void setIdUserMsg(Long idUserMsg) {
        this.idUserMsg = idUserMsg;
    }

    public Long getIdTopicMsg() {
        return idTopicMsg;
    }

    public void setIdTopicMsg(Long idTopicMsg) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}