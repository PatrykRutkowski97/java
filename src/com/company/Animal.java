package com.company;


import java.io.File;

public class Animal implements saleable {
    final String species;
    public String name;
    private Double weight;
    File pic;

    public Animal(String species, String name) {
        this.species = species;
        this.name = name;
        if (species == "dog")
            this.weight = 6.0;
        else if (species == "cat")
            this.weight = 4.0;
        else if (species == "kangaroo")
            this.weight = 55.0;
        else
            weight = 1.0;   // I assume that any other animal of a different species weighs 1 kg
    }

    void feed() {
        if (this.weight <= 0)
            System.out.println(this.name + " is dead. RIP");
        else {
            weight += 1;
            System.out.println(this.name + " was fed. Weight increased to " + this.weight + " kg.");
        }
    }

    void takeForWalk() {

        if (this.weight <= 0)
            System.out.println(this.name + " is dead. He won't stand up.");
        else {
            weight -= 1;
            System.out.println(this.name + " was on a walk. Weight reduced to " + this.weight + " kg.");
        }
    }

    @Override
    public boolean equals(Object x) {
        if (this == x)
            return true;
        if (x == null || getClass() != x.getClass())
            return false;

        Animal animalArg = (Animal) x;
        return species == animalArg.species &&
                name == animalArg.name &&
                weight == animalArg.weight;
    }

    @Override
    public String toString() {
        return species + " " + name + " " + weight;
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.pet != this)
            System.out.println(seller.firstName + " does not own this animal. Transaction failed.");
        else if (buyer.getCash() < price)
            System.out.println(buyer.firstName + " doesn't have enough money. Transaction failed.");
        else {
            buyer.setCash(buyer.getCash() - price);
            seller.setCash((seller.getCash() + price));
            seller.pet = null;
            buyer.pet = this;


            System.out.println("The transaction was successful!\n" +
                    "Seller " + seller.firstName + " " + seller.lastName +
                    " sold to " + buyer.firstName + " " + buyer.lastName +
                    " animal species " + this.species + " named " + this.name +
                    " for a price " + price + ".");

        }
    }
}
