public class testBackBoneBST {
    public static void main(String[] args) {
        Node root = new Node(5);
        Node node10 = new Node(10);
        Node node20 = new Node(20);
        Node node15 = new Node(15);
        Node node30 = new Node(30);
        Node node25 = new Node(25);
        Node node40 = new Node(40);
        Node node23 = new Node(23);
        Node node28 = new Node(28);

        root.appendRight(node10);
        node10.appendRight(node20);
        node20.appendLeft(node15);
        node20.appendRight(node30);
        node30.appendLeft(node25);
        node30.appendRight(node40);
        node25.appendLeft(node23);
        node25.appendRight(node28);

        BinaryTree tree = new BinaryTree(root);

        System.out.println(tree.getHeight(root));

    }
}
