package Problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Campus {
    private ArrayList<Person> people ;
    private ArrayList<Person>  recoveredPeople;
    private ArrayList<Person>  oneDosePeople;
    private ArrayList<Person>  anotherDosePeople;

    public void plan(ArrayList<Person>  people, ArrayList<Person>  recoveredPeople, ArrayList<Person>  oneDosePeople, ArrayList<Person>  anotherDosePeople ){
        Scanner input = new Scanner(System.in);
        for (int i=0; i<10;i++){
            System.out.println("Enter the number sid");
            String id = input.nextLine();
            System.out.println("Is the person recovered");
            Boolean recovered = input.nextBoolean();
            System.out.println("Enter the number of doses");
            int numDoses = input.nextInt();

            Person person = new Person(id, recovered, numDoses);

            if (recovered){
                recoveredPeople.add(person);
            }
            if (numDoses == 1){
                oneDosePeople.add(person);
            }
            if(numDoses == 2){
                anotherDosePeople.add()
            }
        }
    }

    public boolean isEligible(String id){

    }
}
