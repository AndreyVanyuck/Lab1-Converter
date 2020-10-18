package com.example.converter.unit;

interface IValueConverter {
    public double Convert(double num);
    public void SetTargetMetric(String targetMetric);
    public void SetSourceMetric(String sourceMetric);
}

