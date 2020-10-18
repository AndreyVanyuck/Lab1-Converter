package com.example.converter.unit;


import java.util.HashMap;
import java.util.Map;

//interface Operation{
//    int execute(int x);
//}

public class TemperatureUnit  {
    private Map<Temperature, Double> relativeToStandard;

    public TemperatureUnit(){
        relativeToStandard = new HashMap<>();
        relativeToStandard.put(Temperature.CELSIUS, 1.0);
        relativeToStandard.put(Temperature.FAHRENHEIT, 33.8);
        relativeToStandard.put(Temperature.KELVIN, 274.15);
    }


//    private static Operation ToCelsius(Temperature targetMetric){
//        switch (targetMetric){
//            case Celsius:
//                return (x) -> x;
//            case Kelvin:
//                return (x) -> x - 273;
//            case Fahrenheit:
//                return (x) -> (x - 32) * 5 / 9;
//        }
//        return null;
//    }
//
//    private static Operation ToSourseMetric(Temperature sourceMetric){
//        switch (sourceMetric){
//            case Celsius:
//                return (x) -> x;
//            case Kelvin:
//                return (x) -> x + 273;
//            case Fahrenheit:
//                return (x) -> (x * 9 / 5) + 32;
//        }
//        return null;
//    }
//
//
//    @Override
//    public double Convert(double num) {
//        return 0;
//    }
//
//    @Override
//    public void SetTargetMetric(String targetMetric) {
////        TargetMetric = targetMetric;
//    }
//
//    @Override
//    public void SetSourceMetric(String sourceMetric) {
////        SourceMetric = sourceMetric;
//    }
}
