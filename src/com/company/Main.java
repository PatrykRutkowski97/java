package com.company;

import creatures.Animal;
import creatures.FarmAnimal;
import creatures.Pet;
import devices.Car;
import devices.Phone;

public class Main {

    public static void main(String[] args) {

        System.out.println("----------------------------- ZADANIE 1 -----------------------------");
        Animal animal = new Pet("dog", "Ricki");
        animal.feed();
        for (int i = 0; i < 8; i++)
            animal.takeForWalk();

        System.out.println("\nLet's kill another one...\n");

        Animal animal2 = new Pet("cat", "Kitty");
        animal2.feed();
        for (int i = 0; i < 8; i++)
            animal2.takeForWalk();

        System.out.println("----------------------------- ZADANIE 2 -----------------------------");

        Human human = new Human("Jan", "Kowalski");
        Car car1 = new Car("Kia", "Stinger", 270, "red");

        // human.car = car1;

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

        System.out.println("----------------------------- ZADANIE 6 -----------------------------");

        Car carA = new Car("Fiat", "126p", 110, "blue");
        Car carB = new Car("Fiat", "126p", 110, "blue");

        System.out.println("Print whole object:"); // in practice toString() method
        System.out.println(carA);
        System.out.println(carB);

        System.out.println("\nCar comparison using '==' : result: " + (carA == carB));
        System.out.println("Car comparison using equals() - without override: was false");
        System.out.println("Car comparison using equals() - after override: " + carA.equals(carB)); // correct comparison

        // ------------ toString() ----------------

        Phone phone = new Phone("Samsung", "Note 10", 8.8, "Android");
        System.out.println(animal);
        System.out.println(phone);
        System.out.println(pasek);
        System.out.println(human3);

        System.out.println("----------------------------- ZADANIE 7 -----------------------------");

        phone.turnOn();
        car1.turnOn();


        System.out.println("----------------------------- ZADANIE 8 -----------------------------");
        Animal petForSale = new Pet("dog", "Mailo");
        Car carForSale = new Car("Fiat", "Panda", 120, "red", 1000.0, 1998);
        Human buyer1 = new Human("Marcin", "Kowalski", 2000.0, 600.0);
        Human seller1 = new Human("Krzysztof", "Krawczyk", 35000.0, 2000.0, petForSale);
        Human buyer2 = new Human("Marcin", "Marciniak", 2000.0, 5500.0);
        Human seller2 = new Human("Tomasz", "Adamek", 40000.0, 1000.0, carForSale);


        System.out.println("\n-------- ANIMAL TRADE ---------");

        System.out.println("-- checking the case if the buyer does not have enough money: --");
        petForSale.sell(seller1, buyer1, 800.0);

        System.out.println("\n-- checking the case if the buyer does not own the animal being sold: --");
        petForSale.sell(buyer1, seller1, 500.0);

        System.out.println("\nBefore transaction:" +
                "\nBuyer cash: " + buyer1.getCash() +
                "\nBuyer animal: " + buyer1.pet +
                "\nSeller cash: " + seller1.getCash() +
                "\nSeller animal: " + seller1.pet
                + "\n");

        petForSale.sell(seller1, buyer1, 500.0);

        System.out.println("\nAfter transaction:" +
                "\nBuyer cash: " + buyer1.getCash() +
                "\nBuyer animal: " + buyer1.pet +
                "\nSeller cash: " + seller1.getCash() +
                "\nSeller animal: " + seller1.pet +
                "\n");


        System.out.println("-------- CAR TRADE ---------");

        System.out.println("-- checking the case if the buyer does not have enough money: --");
        carForSale.sell(seller2, buyer2, 34000.0);

        System.out.println("\n-- checking the case if the buyer does not own the car being sold: --");
        carForSale.sell(buyer2, seller2, 3000.0);

        System.out.println("\nBefore transaction:" +
                "\nBuyer cash: " + buyer2.getCash() +
                "\nBuyer car: " + buyer2.getCar() +
                "\nSeller cash: " + seller2.getCash() +
                "\nSeller car: " + seller2.getCar() +
                "\n");

        carForSale.sell(seller2, buyer2, 3000.0);

        System.out.println("\nAfter transaction:" +
                "\nBuyer cash: " + buyer2.getCash() +
                "\nBuyer car: " + buyer2.getCar() +
                "\nSeller cash: " + seller2.getCash() +
                "\nSeller car: " + seller2.getCar() +
                "\n");


        System.out.println("--------- PHONE TRADE ---------");

        seller2.setPhone(phone);

        System.out.println("-- checking the case if the buyer does not have enough money: --");
        phone.sell(seller2, buyer2, 30000.0);

        System.out.println("\n-- checking the case if the buyer does not own the phone being sold: --");
        phone.sell(buyer2, seller2, 3000.0);

        System.out.println("\nBefore transaction:" +
                "\nBuyer cash: " + buyer2.getCash() +
                "\nBuyer phone: " + buyer2.getPhone() +
                "\nSeller cash: " + seller2.getCash() +
                "\nSeller phone: " + seller2.getPhone() +
                "\n");


        phone.sell(seller2, buyer2, 300.0);

        System.out.println("\nAfter transaction:" +
                "\nBuyer cash: " + buyer2.getCash() +
                "\nBuyer phone: " + buyer2.getPhone() +
                "\nSeller cash: " + seller2.getCash() +
                "\nSeller phone: " + seller2.getPhone());


        // human.sell(human2, human3, 1.1); - can't sell human, because method sell(Human human, Human human, Double price) not exist in human class


        System.out.println("----------------------------- ZADANIE 9 -----------------------------");

        FarmAnimal cow = new FarmAnimal("cow", "Milka");
        cow.feed();
        cow.feed(20.0);
        cow.beEaten();

        Pet pet = new Pet("dog", "Reksio");
        pet.feed();
        pet.feed(3.0);
    }
}
