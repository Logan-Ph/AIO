package Problem2;

public class Person {
    private String id;
    private boolean recovered;
    private int numDoses;

    public Person(String id, boolean recovered, int numDoses) {
        this.id = id;
        this.recovered = recovered;
        this.numDoses = numDoses;
    }
}
