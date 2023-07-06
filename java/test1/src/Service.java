public class Service {
    private String service, status;
    private double distance,cost;

    public Service(String service, double distance){
        this.distance = distance;
        this.service = service;
        if(this.service=="FoodDeliveryService"){
            this.cost = this.distance*2;
        }else{
            this.cost = this.distance*4;
        }
        this.status = "Booked";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getService() {
        return service;
    }

    public double getCost() {
        return cost;
    }

    public String getStatus() {
        return status;
    }

    public double getDistance() {
        return distance;
    }
}
