import java.util.Arrays;

public class testBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(7);
        Node node2 = new Node(3);
        Node node3 = new Node(11);
        Node node4 = new Node(1);
        Node node5 = new Node(5);
        Node node6 = new Node(9);
        Node node7 = new Node(13);
        Node node8 = new Node(4);
        Node node9 = new Node(6);
        Node node10 = new Node(8);
        Node node11 = new Node(12);
        Node node12 = new Node(14);

        BinaryTree tree = new BinaryTree(root);
        root.appendLeft(node2);
        root.appendRight(node3);

        node2.appendLeft(node4);
        node2.appendRight(node5);

        node3.appendLeft(node6);
        node3.appendRight(node7);

        node5.appendLeft(node8);
        node5.appendRight(node9);

        node6.appendLeft(node10);

        node7.appendLeft(node11);
        node7.appendRight(node12);

        System.out.println(tree.getHeight(root));

        System.out.println("Preorder Traversal: ");
        tree.preorderTraversal(root);
        System.out.println("");

        System.out.println("Inorder Traversal: ");
        tree.inorderTraversal(root);
        System.out.println("");


        System.out.println("Postorder Traversal: ");
        tree.postorderTraversal(root);
        System.out.println("");

        System.out.println(tree.getHeight(root));

        tree.remove(node3);
        System.out.println("Preorder Traversal: ");
        tree.preorderTraversal(root);
        System.out.println("");

        System.out.println(tree.getHeight(root));


    }


}

