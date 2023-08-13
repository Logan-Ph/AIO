import java.util.Scanner;

public class DMV {
    private String name,address,email;
    private int phoneNumber;
    private Person representative;

    public DMV(String name, String address, String email, int phoneNumber, Person representative) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.representative = representative;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Person getRepresentative() {
        return representative;
    }

    public void setRepresentative(Person representative) {
        this.representative = representative;
    }

    public void signedVehicle(Vehicle vehicle, Person person){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the register date");
        String date = input.nextLine();
        vehicle.setOwner(person);
        vehicle.setRegisDate(date);
    }
}
