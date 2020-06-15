package devices;

public class Diesel extends Car {
    public Diesel(String producer, String model, int maxSpeed, String color) {
        super(producer, model, maxSpeed, color);
    }

    public Diesel(String producer, String model, int maxSpeed, String color, Double value) {
        super(producer, model, maxSpeed, color, value);
    }

    public Diesel(String producer, String model, int maxSpeed, String color, Double value, int yearOfProduction) {
        super(producer, model, maxSpeed, color, value, yearOfProduction);
    }

    @Override
    public void refuel() {
        System.out.println("bul.. bul.. bul.. tanked up to full!");
    }
}
