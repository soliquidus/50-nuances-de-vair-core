package dev.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.enums.WeatherLabel;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDto {

    @JsonProperty(value = "weather")
    private List<Description> description;
    @JsonProperty(value = "main")
    private List<MainWeather> weather;
    private List<Wind> wind;
    private LocalDateTime date;


    /* Getter*/
    public WeatherLabel getDescription() {
        return description.get(0).getWeatherLabel();
    }

    public Float getTemperature() {
        return weather.get(0).getCelcius();
    }

    public Integer getPressure() {
        return weather.get(0).getPressure();
    }

    public Integer getHumidity() {
        return weather.get(0).getHumidity();
    }

    public Float getWindSpeed() {
        return wind.get(0).speed;
    }

    public LocalDateTime getDate() {
        return LocalDateTime.now();
    }

    /* Class */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Description {
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
            return celcius - 273.15F;
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
