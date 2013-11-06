package ua.com.sourceit;

import ua.com.sourceit.animals.Animal;
import ua.com.sourceit.animals.CanLay;

/**
 * User: alexkorotkikh
 * Date: 11/5/13
 * Time: 8:14 PM
 */
public class Person implements CanLay {
    @Override
    public void lay(Animal animal) {
        System.out.println("person is laying an animal called " + animal.getName());
    }
}
