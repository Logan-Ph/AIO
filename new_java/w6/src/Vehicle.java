
public class Vehicle {
    private String VIN,maker,model,color,engine,size, fuelType, licensePlate;
    private Person owner;
    private int year;
    private String regisDate;
    public Vehicle(String VIN, String maker, String model, String color, String engine, String size, String fuelType, String licensePlate, int year) {
        this.VIN = VIN;
        this.maker = maker;
        this.model = model;
        this.color = color;
        this.engine = engine;
        this.size = size;
        this.fuelType = fuelType;
        this.licensePlate = licensePlate;
        this.year = year;
        this.owner = null;
    }

    public void setRegisDate(String date) {
        this.regisDate = date;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "VIN='" + VIN + '\'' +
                ", maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                ", size='" + size + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", owner='" + owner + '\'' +
                ", year=" + year +
                ", regisDate='" + regisDate + '\'' +
                '}';
    }
}
