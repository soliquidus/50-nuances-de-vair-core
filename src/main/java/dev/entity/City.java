package dev.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cn_city")
public class City extends BaseEntity {
    @Column( length = 50)
    private String name;

    @Column
    private String zipCode;

    @Column
    private Double longitude;

    @Column
    private Double latitude;

    @ManyToOne
    @JoinColumn(name = "id_department")
    private Department department;

    @OneToOne
    private Census census;

    @OneToOne
    private Pollution pollution;

    @OneToOne
    private Weather weather;

    @ManyToMany(mappedBy = "cities")
    private List<User> users;

    public City() {
    }

    public City(String name, String zipCode, Department department) {
        this.name = name;
        this.zipCode = zipCode;
        this.department = department;
    }

    public City(String name, String zipCode, Double longitude, Double latitude, Department department, Census census, Pollution pollution, Weather weather, List<User> users) {
        this.name = name;
        this.zipCode = zipCode;
        this.longitude = longitude;
        this.latitude = latitude;
        this.department = department;
        this.census = census;
        this.pollution = pollution;
        this.weather = weather;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Census getCensus() {
        return census;
    }

    public void setCensus(Census census) {
        this.census = census;
    }

    public Pollution getPollution() {
        return pollution;
    }

    public void setPollution(Pollution pollution) {
        this.pollution = pollution;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}