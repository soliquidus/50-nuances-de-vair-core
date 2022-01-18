package dev.enums;

public enum WeatherLabel {
    CLEAR_SKY("clear sky", "01d.png"),
    FEW_CLOUDS("few clouds", "02d.png"),
    SCATTERED_CLOUDS("scattered clouds", "03d.png"),
    BROKEN_CLOUDS("broken clouds", "04d.png"),
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
}
