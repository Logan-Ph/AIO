public class Client{
    private String name;
    private Service service;
    public Client(String name){
        this.name = name;
    }

    public Service getService(){
        return this.service;
    }

    public String getName() {
        return name;
    }

    public void Booked(double distance, String service){
        this.service = new Service(service, distance);
        System.out.println("The client " + this.name + " has booked the service "+ this.service.getService());
    }

    @Override
    public String toString() {
        return "Jerry Service: Service: distance="+this.service.getDistance() +", status:"+this.service.getStatus()+", cost="+this.service.getCost()+", "+ this.service.getService();
    }
}
