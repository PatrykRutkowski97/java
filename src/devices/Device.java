package devices;

public abstract class Device {
    public String producer;
    public String mode;
    public int yearOfProduction;

    public abstract void turnOn();

    @Override
    public String toString() {
        return producer + " " + mode + " " + yearOfProduction;
    }
}
