package com.company;

import devices.Car;
import devices.Phone;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Human {
    public String firstName;
    public String lastName;
    private Double salary;
    protected Phone phone;
    public Animal pet;
    private Car car;
    private Double cash;

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Human(String firstName, String lastName, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Human(String firstName, String lastName, Double salary, Double cash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.cash = cash;
    }

    public Human(String firstName, String lastName, Double salary, Double cash, Animal pet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.cash = cash;
        this.pet = pet;
    }

    public Human(String firstName, String lastName, Double salary, Double cash, Car car) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.cash = cash;
        this.car = car;
    }

    public Double getSalary() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        System.out.println("Salary amount: " + this.salary + ", checked " + dtf.format(LocalDateTime.now()));
        return salary;
    }

    public void setSalary(Double salary) {
        if (salary < 0)
            System.out.println("Salary cannot be negative.");
        else {
            System.out.println("New data has been sent to the accounting system.");
            System.out.println("You are required to collect an annex to the contract from the human resources department.");
            System.out.println("Hello! It's us, your ZUS & US Team! You can't hide from us!");
            this.salary = salary;
        }
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        if (car == null) {
            this.car = null;
        } else {
            if (this.salary > car.value) {
                this.car = car;
                System.out.println("Congratulations " + this.firstName + "! You bought " + car.producer + " " + car.model + "for cash!");
            } else if (salary > car.value / 12) {
                this.car = car;
                System.out.println("Congratulations " + this.firstName + "! You bought " + car.producer + " " + car.model + " on instalments!");
            } else
                System.out.println("Sorry " + this.firstName + ".. You can't afford a car. You should change job or go to university.");
        }

    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + salary + " " + phone + " " + pet + " " + car;
    }


}
