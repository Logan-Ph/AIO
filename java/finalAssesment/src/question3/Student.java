package question3;

public class Student implements Comparable<Student>{
    private int id,age;
    private String name,gender;

    private int vote = 0, ticket = 0;



    public Student(int id, String name,  int age , String gender){
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public int getVote() {
        return vote;
    }

    public void addVote(int vote) {
        this.vote += vote;
    }

    public void addTicket(int ticket) {
        this.ticket += ticket;
    }

    public int getTicket() {
        return ticket;
    }

    @Override
    public int compareTo(Student st) {
        if(this.age < st.getAge()){
            return -1;
        } else if (this.age == st.getAge()) {
            return 0;
        }else {
            return 1;
        }

    }
}
