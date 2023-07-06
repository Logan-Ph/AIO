package question2;

import java.io.IOException;
import java.util.ArrayList;
public class TestEmployeeSystem {
    public static void main(String[] args) {
        ArrayList<Employee> employees = null;
        try {
            employees = EmployeeUtils.loadEmployeeData("src/question2/employee_data.txt");
        } catch (IOException e) {
            System.out.println("There is an issue with file path! Please check the path!");
        }
        for (Employee e : employees) {
            System.out.println("Name: " + e.getName());
            System.out.println("Position: " + e.getPosition());
            System.out.println("Salary: " + e.getSalary());
            System.out.println("Performance Bonus: " + e.getPerformanceBonus());
            System.out.println("----------------------");
        }
    }
}
