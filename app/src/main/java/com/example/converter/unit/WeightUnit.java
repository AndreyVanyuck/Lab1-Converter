package com.example.converter.unit;


import java.util.HashMap;
import java.util.Map;

public class WeightUnit implements IValueConverter {

    private Map<String, Double> relativeToStandard;

    public WeightUnit(){
        relativeToStandard = new HashMap<>();
        relativeToStandard.put("Kilogram", 1.0);
        relativeToStandard.put("Ton", 0.001);
        relativeToStandard.put("Gram", 1000.0);
    }

    @Override
    public double fromString(String s) {
        if (relativeToStandard.containsKey(s))
            return relativeToStandard.get(s);
        else throw new IllegalArgumentException();
    }
}
