import java.util.*;
public class GradeBookTest {
    public static void main(String[] args) {
        GradeBook myGradeBook = new GradeBook("sang");

        Scanner input = new Scanner(System.in);

        System.out.printf("Initial course name is: %s\n\n",myGradeBook.getCourseName());

        System.out.println("Please enter the course name");
        String courseName = input.nextLine();
        myGradeBook.setCourseName(courseName);

        myGradeBook.displayMessage();
    }
}
