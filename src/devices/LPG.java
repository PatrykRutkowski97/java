package devices;

public class LPG extends Car {
    public LPG(String producer, String model, int maxSpeed, String color) {
        super(producer, model, maxSpeed, color);
    }

    public LPG(String producer, String model, int maxSpeed, String color, Double value) {
        super(producer, model, maxSpeed, color, value);
    }

    public LPG(String producer, String model, int maxSpeed, String color, Double value, int yearOfProduction) {
        super(producer, model, maxSpeed, color, value, yearOfProduction);
    }

    @Override
    public void refuel() {
        System.out.println("Pss.. pss... tanked up to full!");
    }

}
