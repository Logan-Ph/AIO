import java.util.*;
public class Project {
    private String projectid;
    private Date startDate, endDate;
    private long dif;
    private ArrayList<Employee> listOfEmployee = new ArrayList<Employee>();

    public Project(String projectid, Date startDate, Date endDate){
        this.projectid = projectid;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dif =  Math.abs(endDate.getTime()-startDate.getTime())/86400000;
    }

    public void addEmployee(ArrayList<Employee> listOfEmployee){
        for(Employee e: listOfEmployee){
            this.listOfEmployee.add(e);
        }
    }

    public int estimateBudget(){
        int budget = 0;
        for(Employee e:listOfEmployee){
            budget += e.estimateWeeklySalary()*;
        }
        return budget;
    }

    @Override
    public String toString() {
        return ""+listOfEmployee+"";
    }
}
