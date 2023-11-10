package Problem1;

public class AndroidPhone extends Phone{
    public AndroidPhone(String manufacturerName, String modelName) {
        super(manufacturerName, modelName);
    }

    @Override
    public String getAppHub() {
        return "Play Store";
    }

    @Override
    public String getOS() {
        return "Android";
    }
}
