import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] string = {"a", "b" , "c" , "d", "a", "x", "c"};

        HashMap<String,Integer> set = new HashMap<>();

        for (String str:string){
            set.merge(str, 1, Integer::sum);
        }
        System.out.println(set);
    }
}

