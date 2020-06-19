package com.company;

import devices.Car;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private final Human seller;
    private final Human buyer;
    private final double price;
    private final Date transactionDate;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Transaction(Human seller, Human buyer, Double price) {
        this.seller = seller;
        this.buyer = buyer;
        this.price = price;
        this.transactionDate = new Date();
    }

    public Human getBuyer() {
        return buyer;
    }

    public Human getSeller() {
        return seller;
    }


    @Override
    public String toString() {
        return "\nSeller: " + seller + "\nBuyer: " + buyer
                + "\nPrice: " + price + "\nTransaction date: " + sdf.format(transactionDate) + "\n";
    }


}
