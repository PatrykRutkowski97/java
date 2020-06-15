package devices;

public class Electric extends Car {
    public Electric(String producer, String model, int maxSpeed, String color) {
        super(producer, model, maxSpeed, color);
    }

    public Electric(String producer, String model, int maxSpeed, String color, Double value) {
        super(producer, model, maxSpeed, color, value);
    }

    public Electric(String producer, String model, int maxSpeed, String color, Double value, int yearOfProduction) {
        super(producer, model, maxSpeed, color, value, yearOfProduction);
    }

    @Override
    public void refuel() {
        System.out.println("bzzzz.. bzzz.. bzzz... 100% charged car!");
    }
}
