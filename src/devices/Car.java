package devices;

public class Car extends Device {
    final public String model;
    public Double value;
    public int maxSpeed;
    public String color;

    public Car(String producer, String model, int maxSpeed, String color) {
        this.producer = producer;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.color = color;
    }

    public Car(String producer, String model, int maxSpeed, String color, Double value) {
        this.producer = producer;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.value = value;
    }

    @Override
    public boolean equals(Object x) {
        if (this == x)
            return true;
        if (x == null || getClass() != x.getClass())
            return false;

        Car carArg = (Car) x;
        return producer == carArg.producer &&
                model == carArg.model &&
                maxSpeed == carArg.maxSpeed &&
                color == carArg.color &&
                value == carArg.value;
    }

    @Override
    public String toString() {
        return producer + " " + model + " " + value + " " + maxSpeed + " " + color;
    }

    @Override
    public void turnOn() {
        this.mode = "On";
        System.out.println(this.producer+" "+this.model+" starts working...");
    }
}
