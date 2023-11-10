package Problem1;

public class Phone {
    private String manufacturerName;
    public String modelName;

    public Phone(String manufacturerName, String modelName) {
        this.manufacturerName = manufacturerName;
        this.modelName = modelName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getModelName() {
        return modelName;
    }

    public void installApp(App app) throws IncompatibleAppException{
        if (app instanceof AppleCompatible && this instanceof ApplePhone){
            System.out.println("Visit "+ getAppHub() + " to get more apps");
            ((AppleCompatible) app).saveMoney();
        }
        else if (app instanceof AndroidCompatible && this instanceof AndroidPhone){
            System.out.println("Visit "+ getAppHub() + " to get more apps");
            ((AppleCompatible) app).saveMoney();
        }else if (app instanceof AndroidCompatible && app instanceof AppleCompatible && this instanceof SangPhone){
            System.out.println("Visit "+ getAppHub() + " to get more apps");
            ((AppleCompatible) app).saveMoney();
            ((AppleCompatible) app).saveMoney();
        }else {
            throw new IncompatibleAppException("App is not compatible with phone");
        }
    }

    public String getAppHub(){
        return null;
    };
    public String getOS(){
        return null;
    };
}
