package com.example.converter.unit;


import java.util.HashMap;
import java.util.Map;


public class TimeUnit implements IValueConverter {

    private Map<String, Double> relativeToStandard;

    public TimeUnit(){
        relativeToStandard = new HashMap<>();
        relativeToStandard.put("Hour", 1.0);
        relativeToStandard.put("Minute", 60.0);
        relativeToStandard.put("Second", 3600.0);
    }


    @Override
    public double fromString(String s) {
        if (relativeToStandard.containsKey(s))
            return relativeToStandard.get(s);
        else throw new IllegalArgumentException();
    }
}
