package devices;

public class Phone extends Device {
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
        System.out.println(this.producer+" "+this.model+" starts working...");
    }
}
