package question2;
import question1.Dog;

import java.io.File;
import java.io.IOException;
import java.util.*;
public class EmployeeUtils {
    private static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner filescanner;
    static Manager manager;
    static Developer developer;
    static QATester qaTester;
    static ArrayList<Employee> loadEmployeeData(String path) throws IOException {
        filescanner = new Scanner(new File(path));
        while (filescanner.hasNext()){
            String line = filescanner.nextLine();
            StringTokenizer prompt = new StringTokenizer(line,",");
            int id = Integer.parseInt(prompt.nextToken());
            String name = prompt.nextToken();
            String position = prompt.nextToken();
            double salary = Double.parseDouble(prompt.nextToken());
            switch (position){
                case "Manager":
                    manager = new Manager(id,name,position,salary);
                    employees.add(manager);
                    break;
                case "Developer":
                    developer = new Developer(id,name,position,salary);
                    employees.add(developer);
                    break;
                case "QA Tester":
                    qaTester = new QATester(id,name,position,salary);
                    employees.add(qaTester);
                    break;
            }
        }
        filescanner.close();
        return employees;
    }
}
