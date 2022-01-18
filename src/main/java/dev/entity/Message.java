package dev.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "egassem")
public class Message extends BaseEntity {

    @Column(name = "content", nullable = false, length = 1500)
    private String content;

    @Column(name = "post_time", nullable = false)
    private LocalDateTime postTime;

    /**
     * Constructors
     */
    public Message() {
    }

    public Message(String content, LocalDateTime postTime) {
        this.content = content;
        this.postTime = postTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", postTime=" + postTime +
                '}';
    }
}
