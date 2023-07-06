import java.util.*;
public class Phone {
    private String name, serialNumber;
    public Phone(String name, String serialNumber) throws IllegalArgumentException{
        if((serialNumber.length() == 16) && (name.length()!=0)){
            this.name = name;
            this.serialNumber = serialNumber;
        }
        else {
            throw new IllegalArgumentException("The serial number must be 16 digits or name must not be empty!");
        }
    }
}
