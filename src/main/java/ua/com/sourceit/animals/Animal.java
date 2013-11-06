package ua.com.sourceit.animals;

import java.util.Random;

public abstract class Animal {
    private String name;
    private int pleasantness;

    public Animal(String n /*, int p*/) {
        name = n;

        pleasantness = new Random().nextInt(getMaxPleasantness() - 1) + 1;

//        if (p <= 0) pleasantness = 1;
//        else if (p > getMaxPleasantness()) pleasantness = getMaxPleasantness();
//        else pleasantness = p;
    }

    public static Animal createRandomAnimal() {
        return new Hedgehog("");
    }

    public String getName() {
        return name;
    }

    public int getPleasantness() {
        return pleasantness;
    }

    void beingTouching() {
        pleasantness -= 10;
    }

    public abstract void say();

    protected int getMaxPleasantness() {
        return maxPleasantness;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int maxPleasantness = 100;
}
