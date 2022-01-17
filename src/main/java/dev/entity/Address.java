package dev.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address extends BaseEntity {
    @Column(name = "street_name", length = 50)
    private String streetName;

    @Column(name = "number", length = 15)
    private String number;

    @Column(name = "complement", length = 50)
    private String complement;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_user_add", nullable = false)
    private User idUserAdd;

    public User getIdUserAdd() {
        return idUserAdd;
    }

    public void setIdUserAdd(User idUserAdd) {
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
}