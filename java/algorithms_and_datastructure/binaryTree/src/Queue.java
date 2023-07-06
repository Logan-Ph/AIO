import java.util.ArrayList;

public class Queue {
    private ArrayList array;

    public Queue(){
        this.array = new ArrayList<>();
    }

    public void enQueue(Node node){this.array.add(node);}
    public void deQueue(){this.array.remove(0);}

    public Node peekFront(){return (Node) this.array.get(0);}

    public boolean isEmpty(){return ((this.array.size()>0)?false:true);}
}
