import java.lang.reflect.Type;
import java.util.*;

public class tutorW2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
//        exercise1
//        int n = input.nextInt();
//        for (int i = 0; i<n; i++){
//            for (int j = 0; j<n; j++){
//                System.out.print("*");
//            };
//            System.out.println("");
//        }

//        exercise2
//        int n = input.nextInt();
//        for (int i = 0; i < n; i++) {
//            if ((i == 0) || (i == n - 1)) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print("*");
//                }
//                System.out.println("");
//            } else {
//                for (int j = 0; j < n; j++) {
//                    if (j == 0) {
//                        System.out.print("*");
//                    } else if (j == n - 1) {
//                        System.out.println("*");
//                    } else {
//                        System.out.print(" ");
//                    }
//                }
//            }
//        }

//        exercise3
//        String n = input.nextLine();
//        String[] angle = n.split(" ");
//        int a = Integer.parseInt(angle[0]);
//        int b = Integer.parseInt(angle[1]);
//        int c = Integer.parseInt(angle[2]);
//
//        if ((a == b) && (b == c)) {
//            System.out.println("Equilateral Triangle");
//        } else if ((a == b) || (a == c) || (b == c)) {
//            System.out.println("Isosceles Triangle");
//        } else if ((a + b > c) && (a + c > b) && (b + c > a)) {
//            System.out.println("Scalene Triangle");
//        } else {
//            System.out.print("Not triangle");
//        }

//        exercise4
//        System.out.println("Enter circle 1's center x-,y-coordinates, and radius:");
//        String first_circle = input.nextLine();
//        String[] coor_1 = first_circle.split(" ");
//        double x_1 = Float.parseFloat(coor_1[0]);
//        double y_1 = Float.parseFloat(coor_1[1]);
//        double r_1 = Float.parseFloat(coor_1[2]);
//
//        System.out.println("Enter circle 2's center x-,y-coordinates, and radius:");
//        String second_circle = input.nextLine();
//        String[] coor_2 = second_circle.split(" ");
//        double x_2 = Float.parseFloat(coor_2[0]);
//        double y_2 = Float.parseFloat(coor_2[1]);
//        double r_2 = Float.parseFloat(coor_2[2]);
//
//        double d = Math.sqrt( Math.pow(x_1 - x_2,2) + Math.pow(y_1 - y_2,2));
//
//        if (d <= Math.abs(r_1 - r_2)){
//            System.out.println("One circle is inside the other circle!");
//        } else if (d < r_1 + r_2) {
//          System.out.println("One circle overlaps the other circle!");
//        }
//        else{
//            System.out.println("Two circles do not overlap each other!");
//        }


//        exercise5
//        Dictionary number = new Hashtable();
//        for (int i = 0; i< 100; i++){
//            int n = random.nextInt(11);
//            if (number.get(n) != null){
//                int value = (int) number.get(n) + 1;
//                number.put(n, value);
//            }
//            else {
//                number.put(n,1);
//            }
//        }
//        System.out.println(number);

//        exercise6
        int house  = 1000;
        int player  = 100;
        boolean run = true;
        int round  = 1;
        System.out.println("The house has $" + house);
        System.out.println("The player has $" + player);
        System.out.println("Try your luck to win all money of the house!");

        while (run){
            System.out.println("Round " + round + ":");
            System.out.println("How much do you want to bet?");
            int dice1 = random.nextInt(1,7);
            int dice2 = random.nextInt(1,7);
            int dice3 = random.nextInt(1,7);
            int sumdice = dice1 + dice2 + dice3;
            int money = input.nextInt();

            while (money > player){
                System.out.println("You can not bet more than you have. Try again!");
                money = input.nextInt();
            }

            System.out.println("You have bet $" + money +"!");
            System.out.println("Do you want to bet big or small? (big/small)");

            String bet = input.next();

            System.out.println("The dices are: " + dice1 + " " + dice2 + " " + dice3 + " ");
            System.out.println("The sum of 3 dices is " + sumdice + "!");

            if (dice1 == dice2 && dice2 == dice3){
                System.out.println("You loose $" + money + "!");
                player -= money;
                house += money;
            } else if ( 4<=sumdice && sumdice<= 10 && bet.toLowerCase() == "small") {
                System.out.println("You win $" + money + "!");
                house -= money;
                player += money;
            } else if ( 11<=sumdice && sumdice<= 17 && bet.toLowerCase() == "big") {
                System.out.println("You win $" + money + "!");
                house -= money;
                player += money;
            }
            else {
                System.out.println("You loose $" + money + "!");
                house += money;
                player -= money;
            }
            System.out.println("The house has $" + house);
            System.out.println("The player has $" + player);

            if (player == 0){
                System.out.println("You are out of money! Bye!");
                break;
            }

            System.out.println("Do you still want continue to play?(true/false)");
            run = input.nextBoolean();
            round+=1;

        }
    }
}
