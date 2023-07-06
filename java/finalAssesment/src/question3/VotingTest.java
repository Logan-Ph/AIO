package question3;

public class VotingTest {
    public static void main(String[] args){
        Election election = new Election();

        Student alice = new Student(1, "Alice", 21, "Female");
        Student bob = new Student(2, "Bob", 22, "Male");
        Student charlie = new Student(3, "Charlie", 20, "Male");

        election.addCandidate(alice);
        election.addCandidate(bob);
        election.addCandidate(charlie);

        Student tom = new Student(4, "Tom", 25, "Male");
        Student phong = new Student(5, "Phong", 35, "Male");
        Student james = new Student(6, "James", 17, "Male");
        Student diane = new Student(7, "Diane", 45, "Female");
        Student eve = new Student(8, "Eve", 18, "Female");
        election.addVoter(tom); // valid
        election.addVoter(phong); // valid
        election.addVoter(james); // will print out error below
        election.addVoter(eve); // valid
        election.addVoter(diane); // valid

        election.vote("Tom", "Alice");
        election.vote("Phong", "Bob");
        election.vote("Eve", "Charlie");
        election.vote("Tom", "Bob"); // will print out error below
        election.vote("Diane", "Bob");
        election.vote("No Name", "Alice"); // will print out error below
        election.getResults();
    }
}
