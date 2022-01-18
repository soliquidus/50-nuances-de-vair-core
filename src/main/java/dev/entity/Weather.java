package dev.entity;


import dev.enums.WeatherLabel;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "cn_weather")
public class Weather extends BaseEntity {

    /**
     * Group of weather parameters (Rain, Snow, Extreme etc.)
     */
    @Enumerated
    private WeatherLabel description;

    private Long temperature;
    /**
     *  Atmospheric pressure (on the sea level, if there is no sea_level or grnd_level data), hPa
     */
    private Integer pressure;
    /**
     * Humidity, %
     */
    private Integer humidity;
    /**
     * Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour
     */
    private Long windSpeed;
    /**
     * Datetoday
     */
    private LocalDate date;

    /**
     * RELATION
     * city relation
     */
     @OneToOne
     private City city;


    public Weather() {
    }

    public Weather(WeatherLabel description, Long temperature, Integer pressure, Integer humidity, Long windSpeed, LocalDate date, City city) {
        this.description = description;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.date = date;
        this.city = city;
    }

    public WeatherLabel getDescription() {
        return description;
    }

    public void setDescription(WeatherLabel description) {
        this.description = description;
    }

    public Long getTemperature() {
        return temperature;
    }

    public void setTemperature(Long temperature) {
        this.temperature = temperature;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Long getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Long windSpeed) {
        this.windSpeed = windSpeed;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
