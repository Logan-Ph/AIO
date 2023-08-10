import java.io.*;
import java.util.*;
public class Exercise34 {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new FileWriter("src/students.obj", true));
        System.out.println("Please enter student name: ");
        String name = input.nextLine();

        System.out.println("Please enter student major: ");
        String major = input.nextLine();

        System.out.println("Please enter student GPA: ");
        Double gpa = input.nextDouble();

        Student student = new Student(name,major,gpa);

        pw.printf("%s,%s,%.2f%n",student.getName(),student.getMajor(),student.getGPA());
        pw.close();

        Scanner read = new Scanner(new File("src/students.obj"));
        while(read.hasNext()){
            String line = read.nextLine();
            StringTokenizer inread = new StringTokenizer(line,",");
            String stuName = inread.nextToken();
            String stuMajor = inread.nextToken();
            Double stuGPA= Double.valueOf(inread.nextToken());
            System.out.printf("Student name: %s, major: %s, GPA: %.2f%n",stuName,stuMajor,stuGPA);
        }

    }
}
