package ua.com.sourceit.baboons.animals;

import ua.com.sourceit.baboons.Color;

import java.util.Random;

public abstract class Animal {
    private String name;
    private int pleasantness;
    protected Color color;

    public Animal(String n, Color c) {
        name = n;
        color = c;
        pleasantness = new Random().nextInt(getMaxPleasantness() - 1) + 1;
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
