package Problem1;

public class Main {
    public static void main(String[] args) throws IncompatibleAppException {
        Phone phone = new Phone("Pham", "Sang");
        App app1 = new CanvasApp("canvas", 79);
        App app2 = new GameApp("Game",79);
        App app3 = new App("app",79);

//        phone.installApp(app1);
//        phone.installApp(app2);
        phone.installApp(app3);
    }
}
