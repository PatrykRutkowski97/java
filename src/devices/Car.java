package devices;

import com.company.Human;

import java.util.Arrays;

public abstract class Car extends Device {
    final public String model;
    public Double value;
    public int maxSpeed;
    public String color;

    public Car(String producer, String model, int maxSpeed, String color) {
        this.producer = producer;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.color = color;
    }

    public Car(String producer, String model, int maxSpeed, String color, Double value) {
        this.producer = producer;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.value = value;
    }

    public Car(String producer, String model, int maxSpeed, String color, Double value, int yearOfProduction) {
        this.producer = producer;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.value = value;
        this.yearOfProduction = yearOfProduction;
    }

    public abstract void refuel();


    @Override
    public boolean equals(Object x) {
        if (this == x)
            return true;
        if (x == null || getClass() != x.getClass())
            return false;

        Car carArg = (Car) x;
        return producer == carArg.producer &&
                model == carArg.model &&
                maxSpeed == carArg.maxSpeed &&
                color == carArg.color &&
                value == carArg.value;
    }

    @Override
    public String toString() {
        return producer + " " + model + " " + value + " " + maxSpeed + " " + color + " " + yearOfProduction;
    }

    @Override
    public void turnOn() {
        this.mode = "On";
        System.out.println(this.producer + " " + this.model + " starts working...");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        int numberOfCarsInBuyerGarage = 0;
        for (int i = 0; i < buyer.garage.length; i++) {

            if (buyer.garage[i] != null)
                numberOfCarsInBuyerGarage++;
        }

        if (!Arrays.asList(seller.garage).contains(this))
            System.out.println(seller.firstName + " does not own this car. Transaction failed.");
        else if (buyer.garage.length <= numberOfCarsInBuyerGarage)
            System.out.println(buyer.firstName + " has no place in the garage! Transaction failed.");
        else if (buyer.getCash() < price)
            System.out.println(buyer.firstName + " doesn't have enough money. Transaction failed.");
        else {
            buyer.setCash(buyer.getCash() - price);

            int firstFreePlaceInBuyerGarage = numberOfCarsInBuyerGarage; // zmienna dodana dla czytelności

            buyer.garage[firstFreePlaceInBuyerGarage] = this;

            seller.setCash((seller.getCash() + price));
            seller.garage[Arrays.asList(seller.garage).indexOf(this)] = null;

            System.out.println("The transaction was successful!\n" +
                    "Seller " + seller.firstName + " " + seller.lastName +
                    " sold to " + buyer.firstName + " " + buyer.lastName +
                    " " + this.producer + " " + this.model +
                    " for a price " + price + ".");

        }
    }
}
