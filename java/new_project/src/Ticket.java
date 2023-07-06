import java.util.*;

public class Ticket {
    static Random random = new Random();
    private int TICKET_PRICE = 4;
    private static int MIN = 1;
    private static int MAX = 49;
    private int[] num = new int[6];

    public Ticket(int[] num){
        this.num = num;
    }

    public Ticket(){
        for (int i=0; i<this.num.length;i++){
            this.num[i] = Ticket.getRandomNumber();
        }
    }

    public String getTicketNumber(){
        return Arrays.toString(this.num);
    }

    public static int getRandomNumber(){
        int randnum = random.nextInt(MIN,MAX+1);
        return randnum;
    }

    public int equalTicketNumber(Ticket otherTicket){
        int match =0;
        for(int i=0; i<otherTicket.num.length;i++){
            if(otherTicket.num[i] == this.num[i]){
                match++;
            }
        }
        return match;
    }

    
}
