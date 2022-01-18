package dev.entity;

import javax.persistence.*;

@Embeddable
public class Address {

    @Column(length = 50)
    private String streetName;

    @Column(length = 15)
    private String number;

    @Column(nullable = true, length = 50)
    private String complement;

    public Address() {
    }

    public Address(String streetName, String number, String complement) {
        this.streetName = streetName;
        this.number = number;
        this.complement = complement;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
