package ua.com.sourceit.baboons.animals;

import ua.com.sourceit.baboons.Color;

/**
 * User: alexkorotkikh
 * Date: 11/2/13
 * Time: 12:17 PM
 */
public class Cat extends Animal {
    public Cat(String n) {
        super(n, Color.WHITE);
    }

    @Override
    public String getName() {
        return "Sir " + super.getName();
    }

    @Override
    public void say() {
        System.out.println("Myau!!!");
    }

    public static Animal createRandomAnimal() {
        return new Cat("");
    }

}
