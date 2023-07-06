public class Student {
    private String name,major;
    private double GPA;

    public Student(String name, String major, double GPA){
        this.GPA = GPA;
        this.name = name;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return GPA;
    }

    public String getMajor() {
        return major;
    }
}
