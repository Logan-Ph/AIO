package question2;

public class Developer extends Employee{

    public Developer(int id, String name, String position, double salary) {
        super(id, name, position, salary);
    }

    public double getPerformanceBonus() {
        if (this.getSalary() >=50000){
            return this.getSalary()*0.05;
        }else {
            return this.getSalary()*0.025;
        }
    }
}
