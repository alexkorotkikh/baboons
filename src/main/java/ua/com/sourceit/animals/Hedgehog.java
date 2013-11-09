package ua.com.sourceit.animals;

import ua.com.sourceit.Color;

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
