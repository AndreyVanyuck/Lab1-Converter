package com.example.converter.unit;

public enum UnitCategory {
    TEMPERATURE,
    DISTANCE,
    WEIGHT;

    public static IValueConverter createUnit(UnitCategory category) {
        switch (category) {
            case WEIGHT:
                return new WeightUnit();
            case TEMPERATURE:
                return new TemperatureUnit();
            case DISTANCE:
                return new DistanceUnit();
            default:
                throw new EnumConstantNotPresentException(UnitCategory.class, category.toString());
        }
    }

}
