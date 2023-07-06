import java.util.*;

public class tutorw3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

//        EXERCISE1,2,3,4,5
//        System.out.println("Enter how many random numbers to generate the array:");
//        int n = input.nextInt();
//
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            array[i] = (int) random.nextInt(n + 1);
//        }
//        System.out.println("The generated array is:");
//        System.out.println(Arrays.toString(array));
//
//        int minIdx = getIndexMin(array);
//        System.out.println("The smallest number is "+ array[minIdx] +" at the index " + minIdx);
//
//        int minSubIdx = getIndexMinFrom(array,4);
//        System.out.println("The smallest number is " + array[minSubIdx+4] + " at the index " + minSubIdx + " from the index 4");
//
//        int[] updatedArray = exchangeMinFrom(array,0);
//        System.out.println("The new array after the exchange is: ");
//        System.out.println(Arrays.toString(updatedArray));
//
//        int[] sortedArray = sortBySelection(array);
//        System.out.println("The new array after sorting is:");
//        System.out.println(Arrays.toString(sortedArray));
//    }
//
//    static int getIndexMin(int[] array) {
//        int temp = array[0];
//        int idx = 0;
//        for (int i = 1; i < array.length; i++) {
//            if (temp > array[i]) {
//                temp = array[i];
//                idx = i;
//            }
//        }
//        return idx;
//    }
//
//    static int getIndexMinFrom(int[] array, int from){
//        int[] subArray =Arrays.copyOfRange(array,from, array.length);
//        return getIndexMin(subArray);
//    }
//
//    static int[] exchangeMinFrom(int[] array, int from){
//        int minIdx = getIndexMinFrom(array,from);
//        int temp =  array[from];
//        array[from] = array[minIdx + from];
//        array[minIdx + from] = temp;
//        return array;
//    }
//
//    static int[] sortBySelection(int[] array){
//        int[] sortedArray = array;
//        for(int i = 0; i< array.length; i++){
//            sortedArray = exchangeMinFrom(sortedArray,i);
//        }
//        return sortedArray;
//    }


//        EXERCISE6
//        System.out.println("Enter a new number ID for order:");
//        int id = input.nextInt();
//        System.out.println("How many items in order");
//        int numOrder = input.nextInt();
//        ArrayList<Double> order = new ArrayList<Double>();
//        String itemName;
//        double itemPrice;
//        double sum = 0;
//        for (int i = 1; i <= numOrder; i++) {
//            System.out.println("Please enter the name for item " + i);
//            itemName = input.next();
//            System.out.println("Please enter the price for item " + i);
//            itemPrice = input.nextDouble();
//            sum += itemPrice;
//            order.add(itemPrice);
//        }
//        System.out.println("You have an order with ID " + id);
//        System.out.println("In the order, you have " + numOrder + " items.");
//        System.out.printf("The average price in the order is: %.2f" , sum / numOrder);


//        EXERCISE7
        System.out.println("How many games do you want to play");
        int game = input.nextInt();
        int count = 0;
        int jackpot = 0;
        int won = 0;
        int profit = 0;
        for (int i = 0; i < game; i++) {
            ArrayList<Integer> ticket = new ArrayList<>();
            ArrayList<Integer> winTicket = new ArrayList<>();
            int match = 0;
            int temp = 0;
            System.out.println("Do you want to pick your own ticket numbers (true/false)?");
            boolean pick = input.nextBoolean();
            if (pick) {
                System.out.println("Enter 6 numbers of your ticket (1-49)");
                for (int j = 0; j < 6; j++) {
                    int num = Integer.parseInt(input.next());
                    ticket.add(num);
                    int randnum = random.nextInt(1, 50);
                    winTicket.add(randnum);
                    if (randnum == num) {
                        match += 1;
                    }
                }
            } else {
                for (int j = 0; j < 6; j++) {
                    int num = random.nextInt(1, 50);
                    ticket.add(num);
                    int randnum = random.nextInt(1, 50);
                    winTicket.add(randnum);
                    if (randnum == num) {
                        match += 1;
                    }
                }
//            }
                switch (match) {
                    case 1:
                    case 2:
                        temp += 10;
                        break;
                    case 3:
                        temp += 100;
                        break;
                    case 4:
                        temp += 1000;
                        break;
                    case 5:
                        temp += 5000;
                        break;
                    case 6:
                        temp += 5000000;
                        break;
                }

                System.out.println("You have picked the ticket: " + ticket);
                System.out.println("The winning ticket is: " + winTicket);
                System.out.println("Your ticket has matched " + match + " number(s)");
                System.out.printf("You have won %d$%n", temp);

                if (match == 6) {
                    jackpot += 1;
                } else if (match > 0) {
                    count += 1;
                }
                won += temp;
            }
            System.out.println("The number of games won any money: " + count);
            System.out.println("The number of games matched all 6 numbers: " + jackpot);
            System.out.println("Total money won: $" + won);
            System.out.println("Total ticket cost: $" + game * 4);
            profit = won - game * 4;
            System.out.println("Profit/Loss (won-cost): $" + profit);
        }
    }
}
