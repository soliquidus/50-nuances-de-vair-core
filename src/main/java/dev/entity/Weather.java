package dev.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "weather")
public class Weather extends BaseEntity {
    @Column(name = "label", length = 50)
    private String label;

    @Column(name = "temperature", precision = 15, scale = 3)
    private BigDecimal temperature;

    @Lob
    @Column(name = "humidity")
    private String humidity;

    @Column(name = "wind_speed", precision = 15, scale = 3)
    private BigDecimal windSpeed;

    @Column(name = "date_time")
    private Instant dateTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_city_wtr", nullable = false)
    private City idCityWtr;

    public City getIdCityWtr() {
        return idCityWtr;
    }

    public void setIdCityWtr(City idCityWtr) {
        this.idCityWtr = idCityWtr;
    }

    public Instant getDateTime() {
        return dateTime;
    }

    public void setDateTime(Instant dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(BigDecimal windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}