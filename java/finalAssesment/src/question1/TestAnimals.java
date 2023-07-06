package question1;

import java.util.ArrayList;

public class TestAnimals {
    public static void main(String[] args) {

        Dog buddy = new Dog("Buddy", "Labrador Retriever");

        Cat fluffy = new Cat("Fluffy", "Siamese");

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(buddy);
        animals.add(fluffy);
        for (Animal animal : animals) {
            System.out.println("Name: " + animal.getName());
            System.out.println("Breed: " + animal.getBreed());
            System.out.println("Speak: " + animal.speak());
            System.out.println("------------------");
        }
    }
}
