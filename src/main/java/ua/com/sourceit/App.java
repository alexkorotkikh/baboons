package ua.com.sourceit;

import ua.com.sourceit.animals.Animal;
import ua.com.sourceit.animals.Baboon;
import ua.com.sourceit.animals.CanLay;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Animal[] animals = {
                Animal.createRandomAnimal(),
                Animal.createRandomAnimal(),
                Animal.createRandomAnimal(),
                Animal.createRandomAnimal()
        };

        CanLay[] layers = {
                new Person(),
                new Baboon("aasd")
        };

        for (CanLay layer : layers) {
            for (Animal animal : animals) {
                layer.lay(animal);
                animal.say();
            }
        }
    }
}