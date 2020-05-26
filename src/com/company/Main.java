package com.company;

public class Main {

    public static void main(String[] args) {

    Animal animal = new Animal("dog", "Ricki");
    animal.feed();
    for(int i = 0; i < 8; i++)
        animal.takeForWalk();

    System.out.println("\nLet's kill another one...\n");

    Animal animal2 = new Animal("cat", "Kitty");
    animal2.feed();
    for(int i = 0; i < 8; i++)
        animal2.takeForWalk();
    }
}
