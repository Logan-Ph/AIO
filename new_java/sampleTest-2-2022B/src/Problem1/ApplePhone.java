package Problem1;

public class ApplePhone extends Phone{
    public ApplePhone(String manufacturerName, String modelName) {
        super(manufacturerName, modelName);
    }

    @Override
    public String getAppHub() {
        return "App Store";
    }

    @Override
    public String getOS() {
        return "Apple";
    }
}
