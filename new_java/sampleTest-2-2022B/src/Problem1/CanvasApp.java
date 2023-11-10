package Problem1;

public class CanvasApp extends App implements AppleCompatible{
    public CanvasApp(String name, int version) {
        super(name, version);
    }

    @Override
    public String saveMoney() {
        return "Save enough money to install " + super.toString();
    }
}
