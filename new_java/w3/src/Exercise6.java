import java.lang.reflect.Type;
import java.util.*;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Hashtable<Integer, Integer> ar = new Hashtable<>();
        boolean run = true;

        String user = input.nextLine();
        String[] userAr = user.split(" ");
        try {
            for (String i : userAr) {
                int num = Integer.parseInt(i);
                if (ar.get(num) == null) {
                    ar.put(num, 1);
                } else {
                    ar.put(num, ar.get(num) + 1);
                }
            }

        } catch (Exception e) {
            System.out.println("Invalid input please enter a again");
        }

        for(int i: ar.keySet()){
            if (ar.get(i) == 1){
                System.out.printf("%d ",i);
            }
        }
    }
}
