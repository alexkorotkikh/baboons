package ua.com.sourceit.animals;

import java.util.Random;

public abstract class Animal {
    private String name;
    private int pleasureness;

    public Animal(String n /*, int p*/) {
        name = n;

        pleasureness = new Random().nextInt(getMaxPleasureness() - 1) + 1;

//        if (p <= 0) pleasureness = 1;
//        else if (p > getMaxPleasureness()) pleasureness = getMaxPleasureness();
//        else pleasureness = p;
    }

    public String getName() {
        return name;
    }

    public int getPleasureness() {
        return pleasureness;
    }

    void beingTouching() {
        pleasureness -= 10;
    }

    public abstract void say();

    protected int getMaxPleasureness() {
        return 100;
    }
}
