package devices;

import com.company.Human;
import com.company.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Car extends Device {
    final public String model;
    public Double value;
    public int maxSpeed;
    public String color;
    //public List<Human> ownersList;
    public List<Transaction> transactionList;

    public Car(String producer, String model, int maxSpeed, String color) {
        this.producer = producer;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.color = color;
        //ownersList = new ArrayList<Human>();
        transactionList = new ArrayList<Transaction>();
    }

    public Car(String producer, String model, int maxSpeed, String color, Double value) {
        this.producer = producer;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.value = value;
        //ownersList = new ArrayList<Human>();
        transactionList = new ArrayList<Transaction>();
    }

    public Car(String producer, String model, int maxSpeed, String color, Double value, int yearOfProduction) {
        this.producer = producer;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.value = value;
        this.yearOfProduction = yearOfProduction;
        //ownersList = new ArrayList<Human>();
        transactionList = new ArrayList<Transaction>();
    }

    public abstract void refuel();

/*  -- METODY DLA WERSJI Z LISTĄ WŁAŚCICIELI POJAZDU --
    public boolean wasHumanCarOwner(Human human) {
        if (this.ownersList.contains(human))
            return true;
        else
            return false;
    }

    public boolean checkIfTransactionExist(Human seller, Human buyer) {
        if (!this.ownersList.contains(seller) || !this.ownersList.contains(buyer))
            return false;
        else if (this.ownersList.indexOf(seller) < this.ownersList.indexOf(buyer))
            return true;
        else
            return false;
    }

    public int getNumberOfTransaction() {
        return this.ownersList.size(); // w przypadku wliczenia w transakcję metody setCar(Car car) z klasy Human
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
            //else if (this.ownersList.size() == 0 || this.ownersList.get(ownersList.size() - 1) != seller)
            //    System.out.println(seller.firstName + " isn't last owner. Transaction failed.");
        else if (this.transactionList.size() == 0 || this.transactionList.get(transactionList.size() - 1).getBuyer() != seller)
            System.out.println(seller.firstName + " isn't last owner. Transaction failed.");
        else if (buyer.garage.length <= numberOfCarsInBuyerGarage)
            System.out.println(buyer.firstName + " has no place in the garage! Transaction failed.");
        else if (buyer.getCash() < price)
            System.out.println(buyer.firstName + " doesn't have enough money. Transaction failed.");
        else {
            buyer.setCash(buyer.getCash() - price);

            int firstFreePlaceInBuyerGarage = numberOfCarsInBuyerGarage; // zmienna dodana dla czytelności

            buyer.garage[firstFreePlaceInBuyerGarage] = this;
            this.transactionList.add(new Transaction(seller, buyer, price));

            seller.setCash((seller.getCash() + price));
            seller.garage[Arrays.asList(seller.garage).indexOf(this)] = null;

            //this.ownersList.add(buyer);

            System.out.println("The transaction was successful!\n" +
                    "Seller " + seller.firstName + " " + seller.lastName +
                    " sold to " + buyer.firstName + " " + buyer.lastName +
                    " " + this.producer + " " + this.model +
                    " for a price " + price + ".");
        }
    */


    public boolean wasHumanCarOwner(Human human) {
        for (Transaction transaction : transactionList
        ) {
            if (transaction.getBuyer() == human)
                return true;
        }
        return false;
    }

    public boolean checkIfTransactionExist(Human seller, Human buyer) {
        for (Transaction transaction : transactionList
        ) {
            if (transaction.getSeller() == seller && transaction.getBuyer() == buyer)
                return true;
        }
        return false;
    }

    public int getNumberOfTransaction() {
        return this.transactionList.size(); // w przypadku wliczenia w transakcję również metody setCar(Car car) z klasy Human
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
        else if (this.transactionList.size() == 0 || this.transactionList.get(transactionList.size() - 1).getBuyer() != seller)
            System.out.println(seller.firstName + " isn't last owner. Transaction failed.");
        else if (buyer.garage.length <= numberOfCarsInBuyerGarage)
            System.out.println(buyer.firstName + " has no place in the garage! Transaction failed.");
        else if (buyer.getCash() < price)
            System.out.println(buyer.firstName + " doesn't have enough money. Transaction failed.");
        else {
            buyer.setCash(buyer.getCash() - price);

            int firstFreePlaceInBuyerGarage = numberOfCarsInBuyerGarage; // zmienna dodana dla czytelności

            buyer.garage[firstFreePlaceInBuyerGarage] = this;
            this.transactionList.add(new Transaction(seller, buyer, price));

            seller.setCash((seller.getCash() + price));
            seller.garage[Arrays.asList(seller.garage).indexOf(this)] = null;

            System.out.println("The transaction was successful!\n" +
                    "Seller " + seller.firstName + " " + seller.lastName +
                    " sold to " + buyer.firstName + " " + buyer.lastName +
                    " " + this.producer + " " + this.model +
                    " for a price " + price + ".");

        }
    }

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


}
