package com.example.converter;

import java.lang.annotation.Target;

import javax.xml.transform.Source;

enum Temperature{
        Celsius,
        Fahrenheit,
        Kelvin
}
interface Operation{
    int execute(int x);
}

public class TemperatureConverter implements IValueConverter {
    private Temperature TargetMetric;
    private Temperature SourceMetric;

    private static Operation ToCelsius(Temperature targetMetric){
        switch (targetMetric){
            case Celsius:
                return (x) -> x;
            case Kelvin:
                return (x) -> x - 273;
            case Fahrenheit:
                return (x) -> (x - 32) * 5 / 9;
        }
        return null;
    }

    private static Operation ToSourseMetric(Temperature sourceMetric){
        switch (sourceMetric){
            case Celsius:
                return (x) -> x;
            case Kelvin:
                return (x) -> x + 273;
            case Fahrenheit:
                return (x) -> (x * 9 / 5) + 32;
        }
        return null;
    }


    @Override
    public double Convert(double num) {
        return 0;
    }

    @Override
    public void SetTargetMetric(String targetMetric) {
//        TargetMetric = targetMetric;
    }

    @Override
    public void SetSourceMetric(String sourceMetric) {
//        SourceMetric = sourceMetric;
    }
}
