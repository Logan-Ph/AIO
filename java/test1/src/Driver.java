public class Driver {
    private double wallet;
    private String driverName;

    public Driver( String driverName){
        this.wallet = 0;
        this.driverName = driverName;
    }

    public double getWallet() {
        return wallet;
    }

    public String getDriverName() {
        return driverName;
    }

    public void accepts(Client client){
        Service service = client.getService();
        service.setStatus("Delivering");
        System.out.println("The driver " + getDriverName() + "has accepted the delivery and is currently delivering it!");
    }

    public void completes(Client client){
        Service service = client.getService();
        service.setStatus("Completed");
        setWallet(service.getCost());
        System.out.println("The driver " + getDriverName() + "has completed the delivery!");

    }

    public void setWallet(double amount) {
        this.wallet += amount;
    }

    @Override
    public String toString() {
        return getDriverName() + "'s wallet: " + getWallet();
    }
}
