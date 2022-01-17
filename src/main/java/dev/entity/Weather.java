package dev.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Table(name = "weather", indexes = {
        @Index(name = "id_city_wtr", columnList = "id_city_wtr", unique = true)
})
@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

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

    @Column(name = "id_city_wtr", nullable = false)
    private Long idCityWtr;

    public Long getIdCityWtr() {
        return idCityWtr;
    }

    public void setIdCityWtr(Long idCityWtr) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}