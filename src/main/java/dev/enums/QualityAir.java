package dev.enums;

import java.util.List;

public enum QualityAir {
    GOOD,
    FAIR,
    MODERATE,
    POOR,
    VERY_POOR;

    public static QualityAir byIndex(int i) {
        return List.of(QualityAir.values()).get(i);
    }
}
