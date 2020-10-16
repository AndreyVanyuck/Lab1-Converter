package com.example.converter;

interface IValueConverter {
    public double Convert(double num);
    public void SetTargetMetric(String targetMetric);
    public void SetSourceMetric(String sourceMetric);
}

