public class SavingAccount extends Account{
    private double savingInterestRate;


    public SavingAccount(String id, String name, double savingInterestRate) {
        super(id, name);
        this.savingInterestRate = savingInterestRate;
    }

    public SavingAccount(String id, String name, double balance,double savingInterestRate) {
        super(id, name, balance);
        this.savingInterestRate = savingInterestRate;
    }

    public void calculateIntersetAmount(){
        super.credit(super.getBalance()*this.savingInterestRate);
    }

    public double getSavingInterestRate() {
        return savingInterestRate;
    }

    public void setSavingInterestRate(double interestRate) {
        this.savingInterestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Saving"+super.toString()+", interestRate= "+getSavingInterestRate();
    }
}
