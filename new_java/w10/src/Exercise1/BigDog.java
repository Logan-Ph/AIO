package Exercise1;

public class BigDog extends Dog{
    public BigDog(String name) {
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("Wooow");
    }

    @Override
    public void greets(Dog anotherDog) {
        System.out.println("Woooooooooow");
    }

    public void greets(BigDog anotherDog) {
        System.out.println("Wooooooooooooooooooow");
    }
}
