package com.company;

public class Car {
    final String producer;
    final String model;
    int maxSpeed;
    String color;

    public Car(String producer, String model, int maxSpeed, String color) {
        this.producer = producer;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.color = color;
    }
}
