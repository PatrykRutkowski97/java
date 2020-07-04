package devices;

import com.company.Application;
import com.company.Human;

import java.awt.desktop.AppForegroundListener;
import java.net.URL;
import java.util.*;

public class Phone extends Device {
    static final public String defaultServerAddress = "googleplay.com";
    static final public String defaultProtocol = "http";
    static final public String defaultVersionName = "10.0 Final";
    final public String producer;
    final public String model;
    final public Double screenSize;
    final public String operatingSystem;
    public HashSet<Application> applications;
    public Human owner;


    public Phone(String producer, String model, Double screenSize, String operatingSystem) {
        this.producer = producer;
        this.model = model;
        this.screenSize = screenSize;
        this.operatingSystem = operatingSystem;
        this.applications = new HashSet<Application>();
    }

    public Phone(String producer, String model, Double screenSize, String operatingSystem, Human owner) {
        this.producer = producer;
        this.model = model;
        this.screenSize = screenSize;
        this.operatingSystem = operatingSystem;
        this.applications = new HashSet<Application>();
        this.owner = owner;
    }

    @Override
    public String toString() {
        return producer + " " + model + " " + screenSize + " " + operatingSystem;
    }

    @Override
    public void turnOn() {
        this.mode = "On";
        System.out.println(this.producer + " " + this.model + " starts working...");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.getPhone() != this)
            System.out.println(seller.firstName + " does not own this phone. Transaction failed.");
        else if (buyer.getCash() < price)
            System.out.println(buyer.firstName + " doesn't have enough money. Transaction failed.");
        else {
            buyer.setCash(buyer.getCash() - price);
            seller.setCash((seller.getCash() + price));
            seller.setPhone(null);
            buyer.setPhone(this);

            System.out.println("The transaction was successful!\n" +
                    "Seller " + seller.firstName + " " + seller.lastName +
                    " sold to " + buyer.firstName + " " + buyer.lastName +
                    " " + this.producer + " " + this.model +
                    " for a price " + price + ".");

        }

    }

    public void installApp(Application app) {
        if (this.owner.getCash() < app.price)
            System.out.println("Not enough money to buy this application.");
        else {
            applications.add(app);
            this.owner.setCash(this.owner.getCash() - app.price);
            System.out.println(app.name + " v. " + app.version + " has been successfully installed. Account balance reduced by " + app.price + ".");
        }
    }

    public boolean isAppInstalled(Application app) {
        if (this.applications.contains(app))
            return true;
        else
            return false;
    }

    public boolean isAppInstalled(String appName) {
        for (Application app : applications
        ) {
            if (app.name == appName)
                return true;
        }
        return false;
    }

    public void printFreeApps() {
        System.out.println("List of free applications:");
        for (Application app : applications
        ) {
            if (app.price == 0.0)
                System.out.println(app.name + " v. " + app.version);
        }
    }

    public double calculateSumOfApplicationsValue() {
        double sumOfValue = 0;
        for (Application app : applications
        ) {
            if (app.price > 0.0)
                sumOfValue += app.price;
        }
        return sumOfValue;
    }

    public void printAllAppsByName() {
        List<Application> appList = new ArrayList<>(applications);
        Collections.sort(appList, new Comparator<Application>() {
            @Override
            public int compare(Application o1, Application o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println(appList);
    }

    public void printAllAppsByPriceAsc() {
        List<Application> appList = new ArrayList<>(applications);

        Collections.sort(appList, new Comparator<Application>() {
            @Override
            public int compare(Application o1, Application o2) {
                if (o1 == null) return 1;
                if (o2 == null) return -1;
                if (o1.price > o2.price) return 1;
                else if (o1.price < o2.price) return -1;
                else return 0;
            }
        });
        System.out.println(appList);
    }

    public void installAnnApp(String appName) {
        System.out.println(appName + " has been successfully installed.");
    }

    public void installAnnApp(String appName, String appVersion) {
        System.out.println(appName + " v." + appVersion + " has been successfully installed.");
    }

    public void installAnnApp(String appName, String appVersion, String serverAddress) {
        System.out.println(appName + " v." + appVersion + " from " + serverAddress + " has been successfully installed.");
    }

    public void installAnnApp(List<String> appList) {
        for (String appName : appList
        ) {
            System.out.println(appName + " has been successfully installed.");
        }
        System.out.println("All " + appList.size() + " apps has been successfully installed!");
    }

    public void installAnnApp(URL url) {
        System.out.println(url.getFile().substring(1) + " has been successfully installed."); // improwizowałem :)
    }
}
