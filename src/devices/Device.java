package devices;

import com.company.Human;
import com.company.saleable;

public abstract class Device implements saleable {
    public String producer;
    public String mode;
    public int yearOfProduction;

    public abstract void turnOn();

    @Override
    public String toString() {
        return producer + " " + mode + " " + yearOfProduction;
    }
}
