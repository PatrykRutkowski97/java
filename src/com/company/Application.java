package com.company;

import java.util.Arrays;

public class Application {
    final public String name;
    public String version;
    public Double price;

    public Application(String name, String version, double price) throws Exception {
        if (price < 0.0)
            this.price = 0.0;
        else
            this.price = price;
        this.name = name;
        this.version = version;
    }

    @Override
    public String toString() {
        return this.name + " v. " + this.version + " " + this.price + "$";
    }
}
