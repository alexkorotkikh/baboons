package ua.com.sourceit.baboons.animals;

import ua.com.sourceit.baboons.Color;

/**
 * User: alexkorotkikh
 * Date: 11/2/13
 * Time: 11:59 AM
 */
public class Hedgehog extends Animal {
    public Hedgehog(String n) {
        super(n, Color.GREY);
    }

    @Override
    protected int getMaxPleasantness() {
        return 50;
    }

    @Override
    public void say() {
        System.out.println("Frfrfrfrfr");
    }
}
