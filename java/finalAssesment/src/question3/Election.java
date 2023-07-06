package question3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Election {
    private ArrayList<Student> voters = new ArrayList<>();
    private ArrayList<Student> candidates = new ArrayList<>();

    public void addVoter(Student student){
        if (student.getAge()>=18){
            voters.add(student);
        }
        else {
            System.out.printf("Error: cannot add %s to the voter list%n", student.getName());
        }
    }

    public void addCandidate(Student student){
        if (student.getAge()>18){
            candidates.add(student);
        }
    }

    Student searchCandidate(String name){
        for(Student candidate:candidates){
            if(candidate.getName() == name){
                return candidate;
            }
        }
        return null;
    }

    Student searchVoter(String name){
        for(Student voter:voters){
            if(voter.getName() == name){
                return voter;
            }
        }
        return null;
    }

    public void vote(String voterName, String candidateName){
        Student Voter = searchVoter(voterName);
        Student Can = searchCandidate(candidateName);

        if (Can == null){
            System.out.println("Error: Candidate"+candidateName +" does not exist in the election%n");
        }

        if (Voter == null){
            System.out.println("Error: voter"+ voterName +" does not exist in the election%n");
        }

        if ((Can!= null)&&(Voter != null)){
            if(Voter.getVote()>0){
                System.out.println("Error: voter"+ voterName +" has already voted!%n");
            }else {
                Student newVoter = voters.get(voters.indexOf(Voter));
                Student newCan = candidates.get(candidates.indexOf(Can));
                newVoter.addVote(1);
                newCan.addTicket(1);
                voters.set(voters.indexOf(Voter),newVoter);
                candidates.set(candidates.indexOf(Can),newCan);
            }
        }
    }

    public void getResults(){
        for (Student cd:candidates){
            System.out.printf("%s: %s votes!%n",cd.getName(),cd.getTicket());
        }
    }
}
