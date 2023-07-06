import java.util.*;

public class Exercise2345 {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        System.out.println(Arrays.toString(sortBySelection(new int[] {3,2,4,1,2,5,5,7,8})));
    }

    static int getIndexMin(int[] numbers){
        int idx = 0;
        int temp = 9999;

        for (int i=0;i<numbers.length;i++){
            if (numbers[i]<temp){
                idx = i;
                temp = numbers[i];
            }
        }
        return idx;
    }

    static int getIndexMinForm(int[] numbers, int form){
        int[] subArr = Arrays.copyOfRange(numbers,form,numbers.length);
        return getIndexMin(subArr)+form;
    }

    static int[] exchangeMinFrom(int[] numbers, int form){
        int idx = getIndexMinForm(numbers,form);
        int temp = numbers[form];
        numbers[form] = numbers[idx];
        numbers[idx] = temp;
        return numbers;
    }

    static int[] sortBySelection(int[] numbers){
        for (int i=0; i<numbers.length;i++){
            numbers = exchangeMinFrom(numbers,i);
        }
        return numbers;
    }
}
