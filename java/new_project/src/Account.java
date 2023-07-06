public class Account {
    private double balance = 0;

    public Account(double initialBalance) {
        if (initialBalance > 0.0){
            balance = initialBalance;
        }
    }

    public void credit(double amount){
        balance += amount;
    }

    public double getBalance(){
        return balance;
    }
}
