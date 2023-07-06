public class Node {
    private int data;
    Node left,right;
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void appendRight(Node node){
        this.right = node;
    }

    public void appendLeft(Node node){
        this.left = node;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
