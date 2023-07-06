public class testSLL {
    public static void main(String[] args) {
        SLL linkedList = new SLL(5);
        linkedList.appendNode(new Node(3));
        linkedList.appendNode(new Node(2));
        linkedList.appendNode(new Node(4));
        linkedList.appendNode(new Node(1));
        linkedList.appendNode(new Node(6));
        linkedList.appendNode(new linkedList.getNode(2));
        linkedList.printList();

    }
}
