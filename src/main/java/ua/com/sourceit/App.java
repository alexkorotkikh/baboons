package ua.com.sourceit;

import ua.com.sourceit.animals.Animal;
import ua.com.sourceit.animals.Baboon;
import ua.com.sourceit.animals.Cat;
import ua.com.sourceit.animals.Hedgehog;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Animal[] animals = {
                new Hedgehog("Sonic"),
                new Cat("Murzik"),
                new Cat("Boris")
        };

        Baboon b = new Baboon("Vasya");
        Animal theChosenOne = b.choose(animals);

        b.lay(theChosenOne);
    }
}