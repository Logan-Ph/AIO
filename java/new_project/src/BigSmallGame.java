import java.util.*;
public class BigSmallGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        House house = new House(1000);
        Player player = new Player(100);
        boolean run = true;
        int round = 1;
        System.out.println("The house has $" + house.getWallet());
        System.out.println("The player has $" + player.getWallet());
        System.out.println("Try your luck to win all money of the house!");

        while (run){
            System.out.println("Round " + round + ":");
            System.out.println("How much do you want to bet?");
            House.rollDices();
            int bet = input.nextInt();

            while (bet > player.getWallet()){
                System.out.println("You can not bet more than you have. Try again!");
                bet = input.nextInt();
            }

            player.setBet(bet);

            System.out.println("You have bet $" + player.getBet() +"!");
            System.out.println("Do you want to bet big or small? (big/small)");
            player.setChoice(input.next());

            House.printDice();
            String dice = House.checkDicesResult();
            if ((dice == "small") && player.getChoice()=="small") {
                System.out.println("You win $" + player.getBet() + "!");
                player.addWallet(+player.getBet());
                house.addWallet(-player.getBet());
            } else if ((dice == "big") && player.getChoice()=="big") {
                System.out.println("You win $" + player.getBet() + "!");
                player.addWallet(+player.getBet());
                house.addWallet(-player.getBet());
            }else {
                System.out.println("You lose $" + player.getBet() + "!");
                player.addWallet(-player.getBet());
                house.addWallet(+player.getBet());
            }
            System.out.println("The house has $" + house.getWallet());
            System.out.println("The player has $" + player.getWallet());

            if (player.getWallet() == 0){
                System.out.println("You are out of money! Bye!");
                break;
            }

            System.out.println("Do you still want continue to play?(true/false)");
            run = input.nextBoolean();
            round++;
        }
    }
}
