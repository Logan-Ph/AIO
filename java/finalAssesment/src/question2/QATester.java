package question2;

public class QATester extends Employee{

    public QATester(int id, String name, String position, double salary) {
        super(id, name, position, salary);
    }

    public double getPerformanceBonus() {
        if (this.getSalary() >=50000){
            return this.getSalary()*0.025;
        }else {
            return this.getSalary()*0.01;
        }
    }
}
