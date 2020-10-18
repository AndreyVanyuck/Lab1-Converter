package com.example.converter.unit;


import java.util.HashMap;
import java.util.Map;


public class TemperatureUnit implements IValueConverter {

    private Map<String, Double> relativeToStandard;

    public TemperatureUnit(){
        relativeToStandard = new HashMap<>();
        relativeToStandard.put("Celsius", 1.0);
        relativeToStandard.put("Fahrenheit", 33.8);
        relativeToStandard.put("Kelvin", 274.15);
    }


    @Override
    public double fromString(String s) {
        if (relativeToStandard.containsKey(s))
            return relativeToStandard.get(s);
        else throw new IllegalArgumentException();
    }
}
