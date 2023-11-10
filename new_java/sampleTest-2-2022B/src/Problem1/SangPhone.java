package Problem1;

public class SangPhone extends Phone{
    public SangPhone(String manufacturerName, String modelName) {
        super(manufacturerName, modelName);
    }

    @Override
    public String getAppHub() {
        return "Sang store";
    }

    @Override
    public String getOS() {
        return "Sang";
    }
}
