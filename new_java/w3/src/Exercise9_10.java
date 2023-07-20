import java.util.*;

public class Exercise9_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] ar = new String[3][3];
        String run = "";
        int z = 0;
        while (true) {
            System.out.println("Please enter the position of X <rows> <column>");
            boolean again = true;
            int row;
            int col;
            while (again) {
                row = Integer.parseInt(input.next());
                col = Integer.parseInt(input.next());

                if (ar[row][col] != null) {
                    System.out.println("The position has been occupied, please enter again!");
                } else {
                    ar[row][col] = "X";
                    z++;
                    again = false;
                }
            }
            again = true;
            System.out.println("Please enter the position of O <rows> <column>");
            while (again) {
                row = Integer.parseInt(input.next());
                col = Integer.parseInt(input.next());

                if (ar[row][col] != null) {
                    System.out.println("The position has been occupied, please enter again!");
                } else {
                    ar[row][col] = "O";
                    z++;
                    again = false;
                }
            }

            displayGame(ar);
            run = validateGame(ar);
            if ((Objects.equals(run, "X")) || (Objects.equals(run, "O"))) {
                System.out.println(run + " is the winner!");
                System.out.println("Do you want to continue?");
                System.out.println("press X exit");
                String con = String.valueOf(input.next().charAt(0));
                if (Objects.equals(con, "X")) {
                    break;
                }
                else {
                    ar = new String[3][3];
                }
            }

            if(z == 9){
                ar = new String[3][3];
            }
        }
    }

    static void displayGame(String[][] ar) {
        for (String[] i : ar) {
            for (String j : i) {
                System.out.printf("%s ", j);
            }
            System.out.println();
        }
    }

    static String validateGame(String[][] ar) {
        int[][] wins = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        ArrayList<String> temp = new ArrayList<>();
        for (String[] i : ar) {
            for (String j : i) {
                temp.add(j);
            }
        }
        for (int[] idx : wins) {
            if ((Objects.equals(temp.get(idx[0]), temp.get(idx[1]))) && (Objects.equals(temp.get(idx[1]), temp.get(idx[2])))) {
                return temp.get(idx[0]);
            }
        }
        return null;
    }
}
