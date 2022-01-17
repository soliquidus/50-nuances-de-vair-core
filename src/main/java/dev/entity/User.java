package dev.entity;

import javax.persistence.*;

@Table(name = "user", indexes = {
        @Index(name = "mail", columnList = "mail", unique = true),
        @Index(name = "username", columnList = "username", unique = true)
})
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, length = 25)
    private String username;

    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;

    @Column(name = "mail", nullable = false, length = 50)
    private String mail;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "active_account", nullable = false)
    private Integer activeAccount;

    public Integer getActiveAccount() {
        return activeAccount;
    }

    public void setActiveAccount(Integer activeAccount) {
        this.activeAccount = activeAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}