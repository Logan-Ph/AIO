import java.util.*;
public class Exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Please enter an integer");
        int n = input.nextInt();
        int[] array  = new int[n];

        for (int i =0; i<n; i++){
            int rand = random.nextInt(0,n+1);
            array[i] = rand;
        }

        System.out.println(Arrays.toString(array));
    }

}
