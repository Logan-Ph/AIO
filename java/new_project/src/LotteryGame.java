import java.util.*;

public class LotteryGame {
    static Scanner input = new Scanner(System.in);
    private static int REWARD_TWO_MATCHES = 10;
    private static int REWARD_THREE_MATCHES = 100;
    private static int REWARD_FOUR_MATCHES = 1000;
    private static int REWARD_FIVE_MATCHES = 5000;
    private static int REWARD_SIX_MATCHES = 5000000;


    static int getReward(int numberMatches) {
        switch (numberMatches) {
            case 2:
                return REWARD_TWO_MATCHES;
            case 3:
                return REWARD_THREE_MATCHES;
            case 4:
                return REWARD_FOUR_MATCHES;
            case 5:
                return REWARD_FIVE_MATCHES;
            case 6:
                return REWARD_SIX_MATCHES;
        }
        return 0;
    }

    static Ticket getWinningTicket(){
        Ticket winticket = new Ticket();
        return winticket;
    }


    public static void main(String[] args) {
        System.out.println("How many games do you want to play");
        int count = 0;
        int jackpot = 0;
        int won = 0;
        int game = input.nextInt();
        for (int i = 0; i < game; i++) {
            Ticket winticket = getWinningTicket();
            Person player = new Person(200);
            int win = 0;
            System.out.println("Do you want to pick your own ticket numbers (true/false)?");
            boolean pick = input.nextBoolean();
            if (pick) {
                System.out.println("Enter 6 numbers of your ticket (1-49)");
                int[] ticket = new int[6];
                for (int j = 0; j < 6; j++) {
                    ticket[i] = Integer.parseInt(input.next());
                }
                player.buyTicket(ticket);
            } else {
                int[] ticket = new int[6];
                player.buyTicket();
            }
            int match = winticket.equalTicketNumber(player.getTicket());
            int reward = getReward(match);

            if (match == 6){
                jackpot +=1;
                count++;
                won+=reward;
            } else if (match>1) {
                count++;
                won+=reward;
            }

            System.out.println("You have picked the ticket: " + player.getTicket().getTicketNumber());
            System.out.println("The winning ticket is: " + winticket.getTicketNumber());
            System.out.println("Your ticket has matched " + match + " number(s)");
            System.out.printf("You have won %d$%n", reward);
        }

        System.out.println("The number of games won any money: " + count);
        System.out.println("The number of games matched all 6 numbers: " + jackpot);
        System.out.println("Total money won: $" + won);
        System.out.println("Total ticket cost: $" + game * 4);
        int profit = won - game * 4;
        System.out.println("Profit/Loss (won-cost): $" + profit);
    }
}
