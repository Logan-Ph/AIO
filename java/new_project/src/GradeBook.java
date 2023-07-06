public class GradeBook {
    private String courseName; //vì nó là private nên nó khong thể access qua class instance
    String course;
    GradeBook(String name){
        this.course = name;
//        this.courseName = name;  can not do this neither because "this.courseName" cx đang access thông qua class instance
    }

    public void setCourseName( String name){
        courseName = name;
    }

    public String getCourseName(){
        return courseName;
    }

    public void displayMessage(){
        System.out.printf("Welcome to the grade book \n%s!\n", getCourseName());
    }
}
