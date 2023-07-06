package question2;

public class Employee{
    private String name, position;
    private int id;
    private double salary;
    public Employee(int id, String name, String position, double salary ){
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }


    public double getPerformanceBonus(){
        return 0;
    };
}
