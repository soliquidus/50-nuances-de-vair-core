package dev.entity;


import dev.dto.WeatherDto;
import dev.enums.WeatherLabel;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "cn_weather")
public class Weather extends BaseEntity {

    /**
     * Group of weather parameters (Rain, Snow, Extreme etc.)
     */
    @Enumerated
    private WeatherLabel description;

    private Float temperature;
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
    private Float windSpeed;
    /**
     * Datetoday
     */
    private LocalDateTime date;

    public Weather() {
    }

    public Weather(WeatherLabel description, Float temperature, Integer pressure, Integer humidity, Float windSpeed, LocalDateTime date) {
        this.description = description;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.date = date;
    }

    public Weather(WeatherDto weatherDto) {
        this
                .setDescription(weatherDto.getDescription())
                .setTemperature(weatherDto.getTemperature())
                .setPressure(weatherDto.getPressure())
                .setHumidity(weatherDto.getHumidity())
                .setWindSpeed(weatherDto.getWindSpeed())
                .setDate(weatherDto.getDate());
    }

    public WeatherLabel getDescription() {
        return description;
    }

    public Weather setDescription(WeatherLabel description) {
        this.description = description;
        return this;
    }

    public Float getTemperature() {
        return temperature;
    }

    public Weather setTemperature(Float temperature) {
        this.temperature = temperature;
        return this;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Weather setPressure(Integer pressure) {
        this.pressure = pressure;
        return this;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Weather setHumidity(Integer humidity) {
        this.humidity = humidity;
        return this;
    }

    public Float getWindSpeed() {
        return windSpeed;
    }

    public Weather setWindSpeed(Float windSpeed) {
        this.windSpeed = windSpeed;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Weather setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }
}
