package devices;

import com.company.Saleable;

public abstract class Device implements Saleable {
    public String producer;
    public String mode;
    public int yearOfProduction;

    public abstract void turnOn();

    @Override
    public String toString() {
        return producer + " " + mode + " " + yearOfProduction;
    }
}
