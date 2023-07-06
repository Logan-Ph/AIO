package question1;

public class Cat extends Animal{
    private String breed;

    public Cat(String name, String breed){
        super(name);
        this.breed = breed;
    }

    @Override
    String speak() {
        return "Meow!";
    }

    @Override
    String getBreed() {
        return this.breed;
    }
}
