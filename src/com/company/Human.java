package com.company;

import creatures.Animal;
import devices.Car;
import devices.Phone;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

public class Human {
    private static final int defaultNumberOfCars = 2;
    public String firstName;
    public String lastName;
    public Animal pet;
    public Car[] garage;
    protected Phone phone;
    private Double salary;
    private Double cash;

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        garage = new Car[defaultNumberOfCars];
    }

    public Human(String firstName, String lastName, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        garage = new Car[defaultNumberOfCars];
    }

    public Human(String firstName, String lastName, Double salary, Double cash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.cash = cash;
        garage = new Car[defaultNumberOfCars];
    }

    public Human(String firstName, String lastName, Double salary, Double cash, Animal pet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.cash = cash;
        this.pet = pet;
        garage = new Car[defaultNumberOfCars];
    }

    public Human(String firstName, String lastName, Double salary, Double cash, int garageSize) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.cash = cash;
        garage = new Car[garageSize];
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

    public Car getCar(int carPosition) {
        return garage[carPosition];
    }

    public void setCar(Car car, int carPosition) {
        if (car == null) {
            this.garage[carPosition] = null;
            System.out.println("Error! Car not exist");
        } else if (this.salary > car.value) {
            this.garage[carPosition] = car;
            //car.ownersList.add(this);
            car.transactionList.add(new Transaction(null, this, car.value));
            System.out.println("Congratulations " + this.firstName + "! You bought " + car.producer + " " + car.model + " for cash!");
        } else if (this.salary > car.value / 12) {
            this.garage[carPosition] = car;
            //car.ownersList.add(this);
            car.transactionList.add(new Transaction(null, this, car.value));
            System.out.println("Congratulations " + this.firstName + "! You bought " + car.producer + " " + car.model + " on instalments!");
        } else
            System.out.println("Sorry " + this.firstName + ".. You can't afford a car. You should change job or go to university.");
    }

    public double calculateSumOfCarsValue() {
        double sumOfValue = 0;
        for (Car car : garage
        ) {
            if (car != null)
                sumOfValue += car.value;
        }
        return sumOfValue;
    }

    public void sortGarageByOldCar() {
        Arrays.sort(garage, new CarComparator());
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
        return firstName + " " + lastName + " " + salary + " " + cash + " " + Arrays.asList(garage);
    }

}
