import java.util.ArrayList;

public class Person {
    private String name,email,address;
    private int phoneNumber;

    private ArrayList<Vehicle> vehicles = new ArrayList<>();


    public Person(String name, String email, String address, int phoneNumber) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


}
