package dev.entity;

import javax.persistence.*;

@Table(name = "address", indexes = {
        @Index(name = "id_user_add", columnList = "id_user_add", unique = true)
})
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "street_name", length = 50)
    private String streetName;

    @Column(name = "number", length = 15)
    private String number;

    @Column(name = "complement", length = 50)
    private String complement;

    @Column(name = "id_user_add", nullable = false)
    private Long idUserAdd;

    public Long getIdUserAdd() {
        return idUserAdd;
    }

    public void setIdUserAdd(Long idUserAdd) {
        this.idUserAdd = idUserAdd;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}