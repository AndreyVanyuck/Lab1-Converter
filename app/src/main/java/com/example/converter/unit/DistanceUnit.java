package com.example.converter.unit;


import java.util.HashMap;
import java.util.Map;

public class DistanceUnit implements IValueConverter {

    private Map<String, Double> relativeToStandard;

    public DistanceUnit(){
        relativeToStandard = new HashMap<>();
        relativeToStandard.put("Meter", 1.0);
        relativeToStandard.put("Inch", 0.0254);
        relativeToStandard.put("Foot", 0.3048);
    }


    @Override
    public double fromString(String s) {
        if (relativeToStandard.containsKey(s))
            return relativeToStandard.get(s);
        else throw new IllegalArgumentException();
    }
}
