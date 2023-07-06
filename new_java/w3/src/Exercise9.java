import java.util.*;
public class Exercise9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] ar = new String[3][3];

        for (int i=0; i<9;i++){
            System.out.println("Please enter 'X' or 'O'");
            String user = input.next();
            System.out.println("Please enter the position <rows> <column>");
            int row = Integer.parseInt(input.next());
            int col = Integer.parseInt(input.next());
            ar[row][col] = user;
        }

       displayGame(ar);

    }
    static void displayGame(String[][] ar){
        for (String[] i:ar){
            for (String j:i){
                System.out.printf("%s ",j);
            }
            System.out.println();
        }
    }
}
