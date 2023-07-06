public class Node {
    private int data;
    Node prev,next;

    public Node(int value){
        this.data = value;
        this.prev = null;
        this.next = null;
    }

    public int getData() {
        return data;
    }
}
