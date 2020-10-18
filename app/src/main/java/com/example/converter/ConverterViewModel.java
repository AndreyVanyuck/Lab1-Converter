package com.example.converter;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.converter.unit.Temperature;

public class ConverterViewModel extends ViewModel {
    private MutableLiveData<String> fromValue;
    private MutableLiveData<String> toValue;

    private Enum fromUnit;
    private Enum toUnit;

    private UnitCategory unitCategory;

    public ConverterViewModel(){
        fromUnit = Temperature.FAHRENHEIT;
        toUnit = Temperature.CELSIUS;
        fromValue = new MutableLiveData<>();
        toValue = new MutableLiveData<>();
        unitCategory = UnitCategory.TEMPERATURE;
    }

    public Enum getToUnit() {
        return toUnit;
    }

    public MutableLiveData<String> getFromValue() {
        return fromValue;
    }

    public MutableLiveData<String> getToValue() {
        return toValue;
    }

    public Enum getFromUnit() {
        return fromUnit;
    }
    public void setToValue(String toValue) {
        this.toValue.setValue(toValue);
    }

    public void setToUnit(Enum toUnit) {
        this.toUnit = toUnit;
    }

    public void setFromValue(String fromValue) {
        this.fromValue.setValue(fromValue);
    }

    public void setFromUnit(Enum fromUnit) {
        this.fromUnit = fromUnit;
    }

    public void setUnitCategory(UnitCategory unitCategory) {
        this.unitCategory = unitCategory;
        switch (unitCategory){
            case TEMPERATURE:
                setFromUnit(Temperature.CELSIUS);
                setToUnit(Temperature.CELSIUS);
                break;
            case WEIGHT:
                break;
            case DISTANCE:
                break;
        }
    }
}
