package com.example.converter.unit;

public enum UnitCategory {
    TIME,
    DISTANCE,
    WEIGHT;

    public static IValueConverter createUnit(UnitCategory category) {
        switch (category) {
            case WEIGHT:
                return new WeightUnit();
            case TIME:
                return new TimeUnit();
            case DISTANCE:
                return new DistanceUnit();
            default:
                throw new EnumConstantNotPresentException(UnitCategory.class, category.toString());
        }
    }

}
