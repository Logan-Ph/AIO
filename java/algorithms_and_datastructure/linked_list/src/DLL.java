public class DLL {
    Node head, tail;

    private int length;

    public DLL(int value){
        this.head = new Node(value);
        this.tail = this.head;
        this.length = 1;
    }

    public void appendNode(Node aNode){
        tail.next = aNode;
        aNode.prev = tail;
        tail = tail.next;
        length++;
    }

    public void printList(){
        Node cur = head;
        while (cur != null){
            System.out.printf("%d -> ",cur.getData());
            cur = cur.next;
        }

        if (cur == null){
            System.out.println("null");
        }
    }

    public Node getNode(int i){
        Node p = null;
        if(i < this.length/2){
            p = this.head;
            for(int j=0; j<i; j++){
                p = p.next;
            }
        }else {
            p = this.tail;
            for(int j=length-1; j>i; j--){
                p = p.prev;
            }
        }
        return p;
    }

    public void addBefore(int node, int data){
        Node w = this.getNode(node);
        Node u = new Node(data);

        u.prev = w.prev;
        u.next = w;

        u.next.prev = u;
        u.prev.next = u;

        length++;
    }
}
