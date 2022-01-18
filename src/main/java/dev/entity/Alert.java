package dev.entity;

import javax.persistence.*;

@Entity
@Table(name = "cn_alert")
public class Alert extends BaseEntity {
	
	@Column(name = "message", nullable = false, length = 255)
    private String message;

    public Alert() {
    }

    public Alert(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
