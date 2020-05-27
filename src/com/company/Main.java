package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("----------------------------- ZADANIE 1 -----------------------------");
        Animal animal = new Animal("dog", "Ricki");
        animal.feed();
        for (int i = 0; i < 8; i++)
            animal.takeForWalk();

        System.out.println("\nLet's kill another one...\n");

        Animal animal2 = new Animal("cat", "Kitty");
        animal2.feed();
        for (int i = 0; i < 8; i++)
            animal2.takeForWalk();

        System.out.println("----------------------------- ZADANIE 2 -----------------------------");

        Human human = new Human("Jan", "Kowalski");
        Car car1 = new Car("Kia", "Stinger", 270, "red");

        //human.car = car1;

        System.out.println("----------------------------- ZADANIE 3 i 4 -----------------------------");
        human.setSalary(-100.0);
        human.setSalary(2999.99);
        human.getSalary();

        System.out.println("----------------------------- ZADANIE 5 -----------------------------");

        Car pasek = new Car("Volkswagen", "Passat", 220, "grey", 5500.0);

        // przypadek 1
        Human human2 = new Human("Janusz", "Nosacz", 400.0);
        human2.setCar(pasek);

        // przypadek 2
        Human human3 = new Human("Jan", "Sąsiad", 2500.0);
        human3.setCar(pasek);

        // przypadek 3
        Human human4 = new Human("Andrzej", "Bogacz", 20000.0);
        human4.setCar(pasek);
    }
}
