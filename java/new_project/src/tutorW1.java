import java.util.Scanner;

public class tutorW1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        exercise1
//        System.out.println("*********************");
//        System.out.println("*  Pham Phuoc Sang  *");
//        System.out.println("*********************");


//        exercise2
//        int x =10;
//        int y =20;
//
//        x =x+y;
//        y = x-y;
//        x = x-y;
//
//        System.out.println(x+ " " +y);


//        exercise3
//          int seconds = Integer.parseInt(sc.next());
//          int h  = seconds / 3600;
//          seconds = seconds % 3600;
//          int m = seconds / 60;
//          seconds = seconds - m*60;
//          System.out.println(h+":"+m+":"+seconds);

//        exercise4
//        System.out.println("Enter the coordinates of A");
//        String A = sc.nextLine();
//        String[] numbersa = A.split(" ");
//        int Ax = Integer.parseInt(numbersa[0]);
//        int Ay = Integer.parseInt(numbersa[1]);
//
//        System.out.println("Enter the coordinates of B");
//        String B = sc.nextLine();
//        String[] numbersb = B.split(" ");
//        int Bx = Integer.parseInt(numbersb[0]);
//        int By = Integer.parseInt(numbersb[1]);
//
//        int dx = Ax - Bx;
//        int dy = Ay - By;
//
//        float d = (float) Math.sqrt(Math.pow(dx,2) + Math.pow(dy,2));
//        System.out.printf("Circumference: %.2f%n",  d*4 );
//        System.out.printf("Area: %.2f%n", d*d );


//        exercise5
//        System.out.print("Miles");
//        System.out.printf("%20s %n", "Kilometers");
//
//        for (int i = 0; i < 10; i++) {
//            System.out.printf("%-15s", i);
//            System.out.printf("%.2f %n", i * 1.609);
//        }
//
//        System.out.println("");
//
//        System.out.print("Kilometers");
//        System.out.printf("%10s %n", "Miles");
//
//        for (int i = 20; i <=65; i+=5) {
//            System.out.printf("%-15s", i);
//            System.out.printf("%.2f %n", i / 1.609);
//        }

//        exercise6
        boolean run = true;
        while (run) {
            System.out.print("Enter a positive integer: ");
            int i = Integer.parseInt(sc.next());
            if (i <= 0) {
                System.out.print("Goodbye!");
                break;
            }
            boolean isDivisibleby5 = false;
            boolean isDivisibleby6 = false;

            if (i % 5 == 0) {
                isDivisibleby5 = true;
            }

            if (i % 6 == 0) {
                isDivisibleby6 = true;
            }

            if (isDivisibleby5 && isDivisibleby6) {
                System.out.println(i + " is divisible by both 5 and 6");
            } else if (isDivisibleby5 || isDivisibleby6) {
                System.out.println(i + " is divisible by both 5 or 6, but not both");
            } else {
                System.out.println(i + " is neither divisible by 5 nor 6");
            }
        }
    }
}
