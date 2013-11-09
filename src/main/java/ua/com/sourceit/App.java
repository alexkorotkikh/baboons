package ua.com.sourceit;

import ua.com.sourceit.animals.Baboon;
import ua.com.sourceit.animals.Cat;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        final Object baboon = new Cat("Baboon");

        final boolean b = baboon instanceof Baboon;
        if (b) {
            ((Baboon) baboon).say();
        } else {
            System.out.println("not baboon :(");
        }

    }
}