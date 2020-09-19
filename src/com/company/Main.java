package com.company;

import creatures.Animal;
import creatures.FarmAnimal;
import creatures.Pet;
import devices.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        Animal animal = new Pet("dog", "Ricki");
        animal.feed();
        for (int i = 0; i < 8; i++)
            animal.takeForWalk();

        System.out.println("\nLet's kill another one...\n");

        Animal animal2 = new Pet("cat", "Kitty");
        animal2.feed();
        for (int i = 0; i < 8; i++)
            animal2.takeForWalk();

        Human human = new Human("Jan", "Kowalski");
        Car car1 = new Diesel("Kia", "Stinger", 270, "red");
        human.setSalary(-100.0);
        human.setSalary(2999.99);
        human.getSalary();

        Car pasek = new Diesel("Volkswagen", "Passat", 220, "grey", 5500.0);

        // przypadek 1
        Human human2 = new Human("Janusz", "Nosacz", 400.0);
        human2.setCar(pasek, 1);

        // przypadek 2
        Human human3 = new Human("Jan", "Sąsiad", 2500.0);
        human3.setCar(pasek, 0);

        // przypadek 3
        Human human4 = new Human("Andrzej", "Bogacz", 20000.0);
        human4.setCar(pasek, 0);

        Car carA = new LPG("Fiat", "126p", 110, "blue");
        Car carB = new LPG("Fiat", "126p", 110, "blue");

        System.out.println("Print whole object:"); // in practice toString() method
        System.out.println(carA);
        System.out.println(carB);

        System.out.println("\nCar comparison using '==' : result: " + (carA == carB));
        System.out.println("Car comparison using equals() - without override: was false");
        System.out.println("Car comparison using equals() - after override: " + carA.equals(carB)); // correct comparison


        Phone phone = new Phone("Samsung", "Note 10", 8.8, "Android");
        System.out.println(animal);
        System.out.println(phone);
        System.out.println(pasek);
        System.out.println(human3);

        phone.turnOn();
        car1.turnOn();


        Animal petForSale = new Pet("dog", "Mailo");
        Car carForSale = new LPG("Fiat", "Panda", 120, "red", 1000.0, 1998);
        Human buyer1 = new Human("Marcin", "Kowalski", 2000.0, 600.0);
        Human seller1 = new Human("Krzysztof", "Krawczyk", 35000.0, 2000.0, petForSale);
        Human buyer2 = new Human("Marcin", "Marciniak", 2000.0, 5500.0);
        Human seller2 = new Human("Tomasz", "Adamek", 40000.0, 1000.0, 2);
        seller2.setCar(carForSale, 1);

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

        System.out.println("-- checking the case if the buyer does not have enough money: --");
        carForSale.sell(seller2, buyer2, 34000.0);

        System.out.println("\n-- checking the case if the buyer does not own the car being sold: --");
        carForSale.sell(buyer2, seller2, 3000.0);

        System.out.println("\nBefore transaction:" +
                "\nBuyer cash: " + buyer2.getCash() +
                "\nBuyer car: " + buyer2.getCar(0) +
                "\nSeller cash: " + seller2.getCash() +
                "\nSeller car: " + seller2.getCar(0) +
                "\n");

        carForSale.sell(seller2, buyer2, 3000.0);

        System.out.println("\nAfter transaction:" +
                "\nBuyer cash: " + buyer2.getCash() +
                "\nBuyer car: " + buyer2.getCar(0) +
                "\nSeller cash: " + seller2.getCash() +
                "\nSeller car: " + seller2.getCar(0) +
                "\n");

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


        FarmAnimal cow = new FarmAnimal("cow", "Milka");
        cow.feed();
        cow.feed(20.0);
        cow.beEaten();

        Pet pet = new Pet("dog", "Reksio");
        pet.feed();
        pet.feed(3.0);


        List<String> appNameList = Arrays.asList("Facebook", "Twitter", "Angry Birds");
        URL url = new URL("http", "aplications.com", "/Realcalcv10");

        System.out.println("installAnnApp(String appName): ");
        phone.installAnnApp("Tinder");

        System.out.println("\ninstallAnnApp(String appName, String appVersion):");
        phone.installAnnApp("Gmail", "11.1 beta");

        System.out.println("\ninstallAnnApp(String appName, String appVersion, String serverAddress):");
        phone.installAnnApp("Firefox", "9.0", "www.mozilla.org/pl/firefox/mobile/android/9.0");

        System.out.println("\ninstallAnnApp(List<String> appList):");
        phone.installAnnApp(appNameList);

        System.out.println("\ninstallAnnApp(URL url):");
        phone.installAnnApp(url);

        System.out.println("\nRefueling cars");
        carA.refuel();
        carB.refuel();
        car1.refuel();

        Human humanA = new Human("Jan", "Nowak", 2000.0, 5000.0);
        Human humanB = new Human("Adam", "Blady", 30000.0, 190000.0, 5);
        Car carS1 = new LPG("Fiat", "Multipla", 135, "Blue", 2000.0, 1998);
        Car carS2 = new Diesel("Chevrolet", "Amaro", 265, "Red", 12000.0, 1985);
        Car carB1 = new Diesel("Audi", "S3", 230, "Grey", 120000.0, 2012);
        Car carB2 = new Electric("BMW", "M5", 270, "Black Pearl", 222000.0, 2019);
        Car carB3 = new LPG("Ford", "Fiesta", 190, "Yellow", 4000.0, 2005);
        Car carB4 = new Diesel("Lada", "Samara", 110, "White with red spots", 1200.0, 1992);
        Car carWithoutOwner = new Electric("VW", "Golf", 210, "Blue", 11200.0, 2018);
        humanA.setCar(carS1, 0);
        humanA.setCar(carS2, 1);
        humanB.setCar(carB1, 0);
        humanB.setCar(carB2, 1);
        humanB.setCar(carB3, 2);
        humanB.setCar(carB4, 3);

        System.out.println("\n\n---- car.sell() ----");
        System.out.println("\n-- checking the case if the buyer does not own the car being sold: --");
        carWithoutOwner.sell(humanA, humanB, 2000.0);

        System.out.println("\n-- checking the case if the buyer has not a free garage space: --");
        carB4.sell(humanB, humanA, 1000.0);

        System.out.println("\n-- checking the case if the buyer does not have enough money: --");
        carS2.sell(humanA, humanB, 200000.0);

        System.out.println("\nSeller data before transaction: " + humanA);
        System.out.println("Seller garage value: " + humanA.calculateSumOfCarsValue());
        System.out.println("Buyer data before transaction: " + humanB);
        System.out.println("Buyer garage value: " + humanB.calculateSumOfCarsValue() + "\n");

        carS1.sell(humanA, humanB, 5000.0);

        System.out.println("\nSeller data after transaction: " + humanA);
        System.out.println("Seller garage value: " + humanA.calculateSumOfCarsValue());
        System.out.println("Buyer data after transaction: " + humanB);
        System.out.println("Buyer garage value: " + humanB.calculateSumOfCarsValue() + "");

        System.out.println("\n\n---- sorting the garage by car year ----");
        System.out.println("\nunsorted garage:");
        System.out.println(Arrays.asList(humanB.garage));

        System.out.println("\nsorted garage:");
        humanB.sortGarageByOldCar();
        System.out.println(Arrays.asList(humanB.garage));



        Human human5 = new Human("Tom", "Hanks", 20000.0, 1000000.0);
        Human human6 = new Human("Ted", "Bundy", 10000.0, 200000.0);
        Car auto = new LPG("Fiat", "126p", 120, "White", 2000.0);

        System.out.println("checking the transaction list for a car without an owner:");
        System.out.println(auto.transactionList);

        System.out.println("\nchecking if the person has ever owned a no one's car :");
        System.out.println(auto.wasHumanCarOwner(human5));

        System.out.println("\nchecking the number of sales transactions a no one's car :");
        System.out.println(auto.getNumberOfTransaction());

        System.out.println("\nsetCar():");
        human5.setCar(auto, 0);

        System.out.println("\nchecking the transaction list after the setCar(Car car) method:");
        System.out.println(auto.transactionList);

        System.out.println("\nchecking the number of sales transactions after the setCar(Car car) method:");
        System.out.println(auto.getNumberOfTransaction());

        System.out.println("\nchecking if man A sold the car to man B before transaction:");
        System.out.println(auto.checkIfTransactionExist(human5, human6));

        System.out.println("\nsell():");
        auto.sell(human5, human6, 2000.0);

        System.out.println("\nchecking the transaction list after the sell() method:");
        System.out.println(auto.transactionList);

        System.out.println("\nchecking the number of sales transactions after the setCar(Car car) and sell() methods:");
        System.out.println(auto.getNumberOfTransaction());

        System.out.println("\nchecking if the first owner ever owned the car:");
        System.out.println(auto.wasHumanCarOwner(human5));

        System.out.println("\nchecking if man A sold the car to man B after transaction:");
        System.out.println(auto.checkIfTransactionExist(human5, human6));

        Human androidFan = new Human("Steve", "Jobs", 500.0, 120.0);
        Phone phone2 = new Phone("Samsung", "S9", 8.7, "Android", androidFan);

        Application app1 = new Application("Facebook", "12.0 beta", 0.0);
        Application app2 = new Application("Resident Evil", "4", 12.0);
        Application app3 = new Application("NordVPN", "8.0", 0.0);
        Application app4 = new Application("Automate", "4.1", 11.0);
        Application app5 = new Application("Fifa 2020", "1.0", 20.0);
        Application app6 = new Application("ProteGO", "1.0 beta bety bety", 10000.0);
        Application app7 = new Application("TeamSpeak", "3.0", 13.0);
        androidFan.setPhone(phone2);

        System.out.println("HashSet<Application> for new object:");
        System.out.println(phone2.applications);

        System.out.println("\nChecking if the phone owner has not enough money:");
        phone2.installApp(app6);

        System.out.println("\nOwner account balance before installing the application: " + androidFan.getCash());
        phone2.installApp(app2);
        System.out.println("Owner account balance after installing the application: " + androidFan.getCash());

        System.out.println("\nApps list after single app installation:");
        System.out.println(phone2.applications);

        System.out.println("\nInstalling more apps:");
        phone2.installApp(app1);
        phone2.installApp(app2);
        phone2.installApp(app3);
        phone2.installApp(app4);
        phone2.installApp(app5);

        System.out.println("\nApps list after installation more apps:");
        System.out.println(phone2.applications);

        System.out.println("\nChecking isAppInstaled methods:");
        System.out.println(phone2.isAppInstalled(app7));
        System.out.println(phone2.isAppInstalled("TeamSpeak"));

        phone2.installApp(app7);
        System.out.println(phone2.isAppInstalled(app7));
        System.out.println(phone2.isAppInstalled("TeamSpeak"));

        System.out.println("\nPrint all free apps:");
        phone2.printFreeApps();

        System.out.println("\nGet sum of apps value:");
        System.out.println(phone2.calculateSumOfApplicationsValue());

        System.out.println("\nChecking print Apps by name method:");
        phone2.printAllAppsByName();

        System.out.println("\nChecking print Apps by price method:");
        phone2.printAllAppsByPriceAsc();
    }
}
