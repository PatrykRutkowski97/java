package com.company;

import com.company.Animal;
import com.company.Phone;

public class Human {
    public String firstName;
    public String lastName;
    private Double salary;
    protected Phone phone;
    public Animal pet;
    public Car car;

    public Human(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
