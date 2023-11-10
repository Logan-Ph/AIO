package Problem1;

public class App {
    private String name;
    private int version;

    public App(String name, int version) {
        this.name = name;
        this.version = version;
    }

    @Override
    public String toString() {
        return name +" : " +version;
    }
}
