public class Person {
    private int wallet;
    private Ticket personTicket;

    public Person(int wallet){
        this.wallet = wallet;
    }

    public void buyTicket(){
        personTicket = new Ticket();
    }

    public void buyTicket(int[] num){
        personTicket = new Ticket(num);
    }

    public int getWallet(){
        return this.wallet;
    }

    public void addWallet(int amount){
        this.wallet += amount;
    }

    public Ticket getTicket(){
        return personTicket;
    }
}
