public class House {
    final static private int MIN_SMALL = 4 ;
    final static private int MAX_SMALL = 10 ;
    private int wallet;

    static Dice dice1 = new Dice();
    static Dice dice2 = new Dice();
    static Dice dice3 = new Dice();
    public House(int wallet){
        this.wallet = wallet;
    }

    static void rollDices(){
        dice1.roll();
        dice2.roll();
        dice3.roll();
    }

    static void printDice(){
        System.out.println("The dices are: " + dice1.getValue() + " " + dice2.getValue() + " " + dice3.getValue() + " ");
        System.out.println("The sum of 3 dices is " + sumDices() + "!");
    }

    static int sumDices(){
        int sumdice = dice1.getValue()+dice2.getValue()+dice3.getValue();
        return sumdice;
    }

    static String checkDicesResult(){
        if (dice1.getValue() == dice2.getValue() && dice2.getValue() == dice3.getValue()){
            return "same";
        } else if ( MIN_SMALL<=sumDices() && sumDices()<= MAX_SMALL) {
            return "small";
        } else{
            return "big";
        }
    }

    public int getWallet() {
        return wallet;
    }

    public void addWallet(int wallet){
        this.wallet += wallet;
    }
}
