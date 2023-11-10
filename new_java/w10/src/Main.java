import java.nio.file.FileSystems;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {

}

interface BaseI{void method();}

class BaseC{
    public void method(){
        System.out.println("Insiasdfasdf");
    }
}

class Implc extends BaseC implements BaseI{
    public static void main(String[] args) {
        try {
            Float a = new Float("3.0");
            int b = a.intValue();
            byte c = a.byteValue();
            double d = a.doubleValue();
            System.out.println(b+c+d);
        }catch (NumberFormatException e){
            System.out.println("bad Number");
        }

    }
}