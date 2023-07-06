public class SLL {
    Node head, tail;
    private int length = 0;


    public SLL(int value) {
        this.head = new Node(value);
        this.tail = this.head;
        this.length = 1;
    }

    public void appendNode(Node aNode) {
        tail.next = aNode;
        tail = tail.next;
        length++;
    }

    public void printList() {
        Node cur = head;
        while (cur != null) {
            System.out.printf("%d -> ", cur.getData());
            cur = cur.next;
        }

        if (cur == null) {
            System.out.println("null");
        }
    }

    public Node getNode(int i) {
        Node p = this.head;
        for (int j = 0; j < i; j++) {
            p = p.next;
        }
        return p;
    }
}
