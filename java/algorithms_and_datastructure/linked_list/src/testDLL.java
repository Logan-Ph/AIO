public class testDLL {
    public static void main(String[] args) {
        DLL linkedList = new DLL(5);
        linkedList.appendNode(new Node(3));
        linkedList.appendNode(new Node(2));
        linkedList.appendNode(new Node(4));
        linkedList.appendNode(new Node(1));
        linkedList.appendNode(new Node(6));

        linkedList.addBefore(3,5);
        linkedList.printList();

        Node cur = linkedList.getNode(3);
        System.out.printf("%n%d%n",cur.getData());
    }
}
