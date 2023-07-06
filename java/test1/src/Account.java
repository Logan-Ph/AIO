public class Account {
    private String id,name;
    private double balance;


    public Account(String id, String name){
        this.name = name;
        this.id = id;
    }

    public Account(String id, String name, double balance){
        this.name = name;
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void credit(double amount){
        this.balance += amount;
    }

    public void debit(double amount){
        if (amount <= this.balance ){
            this.balance-=amount;
        }
        else {
            System.out.println("The debit amount is lager than the balance");
        }
    }

    public void transferTo(Account another, double amount){
        debit(amount);
        another.credit(amount);
    }

    @Override
    public String toString() {
        return "Account: id= "+getId()+ ", name= "+getName()+ ", balance= "+getBalance();
    }
}
