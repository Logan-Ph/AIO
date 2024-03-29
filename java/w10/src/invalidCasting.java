import java.io.*;
import java.util.*;

public class invalidCasting {
    static Dog treatMeAsDog(Animal a) {
        try {
            Dog dog = (Dog) a;
            System.out.println("Cast OK");
            return dog;
        } catch (ClassCastException e) {
            System.out.println("Impossible to cast!");
            return null;
        }
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        treatMeAsDog(cat);   // throws an ClassCastException exception
        treatMeAsDog(dog);   // no problem!
    }
}
