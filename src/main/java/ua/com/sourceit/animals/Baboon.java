package ua.com.sourceit.animals;

/**
 * User: alexkorotkikh
 * Date: 11/2/13
 * Time: 12:49 PM
 */
public class Baboon extends Animal implements CanLay {
    public Baboon(String n) {
        super(n);
    }

    public Animal choose(Animal[] animals) {
        Animal animalWithMaxPleasureness = null;

        for (Animal animal : animals) {
            if (animalWithMaxPleasureness == null ||
                    animal.getPleasantness() > animalWithMaxPleasureness.getPleasantness())
                animalWithMaxPleasureness = animal;
        }

        return animalWithMaxPleasureness;
    }


    @Override
    public void say() {
        System.out.println("qwetwesfhert8utyuohuip");
    }

    @Override
    public void lay(Animal animal) {
        System.out.println("Baboon starts touching animal called " + animal.getName());
        while (animal.getPleasantness() > 0) {
            System.out.println("Pleasureness of the animal called " + animal.getName() + " equals " + animal.getPleasantness());
            touch(animal);
        }
        System.out.println("At the end, pleasureness of the animal " + animal.getName() + " equals " + animal.getPleasantness());
    }

    private void touch(Animal animal) {
        animal.beingTouching();
        System.out.println("Pleasureness of the animal called " + animal.getName() + " after touching equals " + animal.getPleasantness());
    }
}
