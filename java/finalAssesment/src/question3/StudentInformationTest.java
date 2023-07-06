package question3;

public class StudentInformationTest {
    public static void main(String[] args) {
        StudentRecords records = new StudentRecords();
        records.addStudent(new Student(1, "Alice", 20, "Female"));
        records.addStudent(new Student(2, "Bob", 22, "Male"));
        records.addStudent(new Student(3, "Charlie", 21, "Male"));
        records.addStudent(new Student(4, "Eve", 20, "Female"));
        System.out.println("Printing all student records:");
        records.printRecords();

        System.out.println("\nCalculating average age of all students:");
        records.calculateAverageAge();

        System.out.println("\nSearching for student record with StudentID 3:");
        records.searchById(3);

        System.out.println("\nSearching for student record with StudentName Alice:");
        records.searchByName("Alice");

        System.out.println("\nSearching for student records with Age 20:");
        records.searchByAge(20);
        System.out.println("\nSearching for student records with Gender 'Male':");
        records.searchByGender("Male");
        System.out.println("\nSorting student records by age in ascending order:");
        records.sortByAge();
    }
}

