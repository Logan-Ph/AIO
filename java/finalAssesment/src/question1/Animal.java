package question1;

public abstract class Animal {
    private String name;
    public Animal(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract String speak();

    abstract String getBreed();
}
