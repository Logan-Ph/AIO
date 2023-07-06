package question1;

public class Dog extends Animal{

    private String breed;

    public Dog(String name, String breed){
        super(name);
        this.breed = breed;
    }

    @Override
    String speak() {
        return "Woof!";
    }

    @Override
    String getBreed() {
        return this.breed;
    }
}
