package ua.com.sourceit.animals;

/**
 * User: alexkorotkikh
 * Date: 11/2/13
 * Time: 11:59 AM
 */
public class Hedgehog extends Animal {
    public Hedgehog(String n) {
        super(n);
    }

    @Override
    protected int getMaxPleasureness() {
        return 50;
    }

    @Override
    public void say() {
        System.out.println("Frfrfrfrfr");
    }
}
