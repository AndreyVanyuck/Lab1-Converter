package com.example.converter.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.converter.unit.IValueConverter;
import com.example.converter.unit.UnitCategory;


public class ConverterViewModel extends ViewModel {
    private MutableLiveData<String> fromValue;
    private MutableLiveData<String> toValue;
    private MutableLiveData<String> fromUnit;
    private MutableLiveData<String>  toUnit;
    private UnitCategory unitCategory;

    public ConverterViewModel(){
        fromUnit = new MutableLiveData<>();
        toUnit = new MutableLiveData<>();
        fromValue = new MutableLiveData<>();
        toValue = new MutableLiveData<>();
        unitCategory = UnitCategory.TIME;
    }

    public String getToValue() {
        return toValue.getValue();
    }

    public void setToValue(String toValue) {
        this.toValue.setValue(toValue);
    }

    public void setToUnit(String toUnit) {
        this.toUnit.setValue(toUnit);
    }

    public void setFromValue(String fromValue) {
        this.fromValue.setValue(fromValue);
    }

    public void setFromUnit(String fromUnit) {
        this.fromUnit.setValue(fromUnit);
    }

    public void setUnitCategory(UnitCategory unitCategory) {
        this.unitCategory = unitCategory;
        switch (unitCategory){
            case TIME:
                setFromUnit("Temperature");
                setToUnit("Temperature");
                break;
            case WEIGHT:
                setFromUnit("Kilogram");
                setToUnit("Kilogram");
                break;
            case DISTANCE:
                setFromUnit("Meter");
                setToUnit("Meter");
                break;
        }
    }

    public void convert(){
        String fromString = fromValue.getValue();
        if (fromString.endsWith(".")) {
            fromString = fromString.substring(0, fromString.length() - 1);
        }
        double fromValue = Double.parseDouble(fromString);

        IValueConverter basicConverter = UnitCategory.createUnit(unitCategory);
        double converted = fromValue / basicConverter.fromString(fromUnit.getValue()) *
                basicConverter.fromString(toUnit.getValue());

        toValue.setValue(Double.toString(converted));
    }
}
