package com.company;

import java.io.File;

public class Animal {
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
    public String toString(){
        return species + " " + name + " " + weight;
    }
}
