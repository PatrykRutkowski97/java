package devices;

import com.company.Human;

import java.net.URL;
import java.util.List;

public class Phone extends Device {
    static final public String defaultServerAddress = "googleplay.com";
    static final public String defaultProtocol = "http";
    static final public String defaultVersionName = "10.0 Final";
    final public String producer;
    final public String model;
    final public Double screenSize;
    final public String operatingSystem;


    public Phone(String producer, String model, Double screenSize, String operatingSystem) {
        this.producer = producer;
        this.model = model;
        this.screenSize = screenSize;
        this.operatingSystem = operatingSystem;
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
