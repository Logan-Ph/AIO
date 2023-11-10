package Problem1;

public class GameApp extends App implements AndroidCompatible{
    public GameApp(String name, int version) {
        super(name, version);
    }

    @Override
    public String saveTime() {
        return "Save enough time to install " + super.toString();
    }
}
