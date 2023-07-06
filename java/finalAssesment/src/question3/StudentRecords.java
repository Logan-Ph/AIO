package question3;

import java.util.ArrayList;
import java.util.Collections;

public class StudentRecords {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void printRecords(){
        for (Student st:students){
            System.out.printf("%s | %s | %s | %s%n",st.getId(),st.getName(),st.getAge(),st.getGender());
        }
    }

    public void searchById(int id){
        for (Student st:students){
            if(st.getId() == id){
                System.out.printf("%s | %s | %s | %s%n",st.getId(),st.getName(),st.getAge(),st.getGender());
            }
        }
    }

    public void searchByName(String name){
        for (Student st:students){
            if(st.getName() == name){
                System.out.printf("%s | %s | %s | %s%n",st.getId(),st.getName(),st.getAge(),st.getGender());
            }
        }
    }

    public void searchByAge(int age){
        for (Student st:students){
            if(st.getAge() == age){
                System.out.printf("%s | %s | %s | %s%n",st.getId(),st.getName(),st.getAge(),st.getGender());
            }
        }
    }

    public void searchByGender(String gender){
        for (Student st:students){
            if(st.getGender() == gender){
                System.out.printf("%s | %s | %s | %s%n",st.getId(),st.getName(),st.getAge(),st.getGender());
            }
        }
    }

    public void calculateAverageAge(){
        double sum = 0;
        for (Student st:students){
            sum+= st.getAge();
        }
        System.out.printf("Average age: %.2f%n",sum/students.size());
    }

    public void sortByAge(){
        Collections.sort(students);
        this.printRecords();
    }
}
