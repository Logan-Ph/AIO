import java.util.*;
public class Exercise6 {
    public static void main(String[] args) {
        Random random = new Random();
        HashMap<Integer,Integer> freq = new HashMap<>();

        for (int i = 0; i<100; i++){
            int n  =  random.nextInt(0,10);
            if (freq.get(n)==null){
                freq.put(n,1);
            }
            else {
                freq.put(n,freq.get(n)+1);
            }
        }

        for(int i: freq.keySet()){
            System.out.printf("%d    :    %d%n",i,freq.get(i));
        }
    }
}
