package dev.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum WeatherLabel {
    CLEAR_SKY("clear sky", "01d.png"),
    FEW_CLOUDS("few clouds", "02d.png"),
    SCATTERED_CLOUDS("scattered clouds", "03d.png"),
    OVERCAST_CLOUDS("overcast clouds","04d.png"),
    SHOWER_RAIN("shower rain", "09d.png"),
    RAIN("rain", "10d.png"),
    THUNDERSTORM("thunderstorm", "11d.png"),
    SNOW("snow", "13d.png"),
    MIST("mist", "50d.png");

    private String label;
    private String icon;

    WeatherLabel(String label, String icon) {
        this.label = label;
        this.icon = icon;
    }
    public static WeatherLabel findWeatherLabelByIcon(String icon){
        return Arrays.stream(WeatherLabel.values())
                .filter(w->w.getIcon().equals(icon))
                .collect(Collectors.toList()).get(0);
    }
    public String getIcon() {
        return icon;
    }
}
