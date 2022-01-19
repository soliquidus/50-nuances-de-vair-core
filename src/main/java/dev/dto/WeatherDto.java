package dev.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.enums.WeatherLabel;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDto {

    @JsonProperty(value = "weather")
    private List<Description> descriptionWeather;
    @JsonProperty(value = "main")
    private MainWeather mainWeather;
    @JsonProperty(value = "wind")
    private Wind wind;


    /* Getter*/
    public WeatherLabel getDescription() {
        return descriptionWeather.get(0).getWeatherLabel();
    }

    public Float getTemperature() {
        return mainWeather.getCelcius();
    }

    public Integer getPressure() {
        return mainWeather.getPressure();
    }

    public Integer getHumidity() {
        return mainWeather.getHumidity();
    }

    public Float getWindSpeed() {
        return wind.speed;
    }

    public LocalDateTime getDate() {
        return LocalDateTime.now();
    }

    /* Class */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Description {
        @JsonProperty("icon")
        private String icon;

        public WeatherLabel getWeatherLabel() {
            return WeatherLabel.findWeatherLabelByIcon(icon);
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MainWeather {
        @JsonProperty(value = "temp")
        private Float celcius;
        private Integer pressure;
        private Integer humidity;

        public Float getCelcius() {
            return celcius ;
        }

        public Integer getPressure() {
            return pressure;
        }

        public Integer getHumidity() {
            return humidity;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Wind {
        private Float speed;

        public Float getSpeed() {
            return speed;
        }
    }
}
