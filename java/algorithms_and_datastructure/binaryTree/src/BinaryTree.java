public class BinaryTree {
    Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    static void preorderTraversal(Node root) {
        if (root != null) {
            System.out.printf("%d ->", root.getData());
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    static void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.printf("%d ->", root.getData());
            inorderTraversal(root.right);
        }
    }

    static void postorderTraversal(Node root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.printf("%d ->", root.getData());

        }
    }

    public Node search(int data) {
        while (root != null) {
            if (root.getData() > data) {
                root = root.left;
            } else if (root.getData() < data) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    public Node findParent(int data) {
        Node parent = null;
        while (root != null) {
            if (root.getData() > data) {
                parent = root;
                root = root.left;
            } else if (root.getData() < data) {
                parent = root;
                root = root.right;
            } else {
                return parent;
            }
        }
        return null;
    }

    static void breadthFirstSearch(Node root) {
        System.out.println("Breadth First Search: ");
        Queue q = new Queue();

        if (root != null) {
            q.enQueue(root);
        }

        while (!q.isEmpty()) {
            Node node = q.peekFront();
            q.deQueue();
            System.out.printf("%d ", node.getData());
            if (node.left != null) {
                q.enQueue(node.left);
            }
            if (node.right != null) {
                q.enQueue(node.right);
            }
        }
    }

    public boolean insert(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            Node parent = null, current = root;
            while (current != null) {
                if (data < current.getData()) {
                    parent = current;
                    current = current.left;
                } else if (data > current.getData()) {
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }
            if (parent.getData() > data) {
                parent.left = new Node(data);
            } else {
                parent.right = new Node(data);
            }
        }
        return true;
    }

    public void remove(Node node) {
        if ((node.left == null) || (node.right == null)) {
            this.splice(node);
        }
        else {
            Node w = node.right;
            while (w.left!=null){
                w = w.left;
            }
            int temp = w.getData();
            splice(w);
            node.setData(temp);
        }
    }

    private void splice(Node node) {
        Node s, p;
        if (node.left != null) {
            s = node.left;
        } else {
            s = node.right;
        }

        if (node == root ){
            root = s;
        }else {
            p = this.findParent(node.getData());
            if(p.left == node){
                p.left = s;
            }
            else {
                p.right = s;
            }
        }
    }

    private void rightRotate(Node node){
        System.out.println(node.getData());
        Node parent = this.findParent(node.getData());
        System.out.println(this.root.getData());
        if (node.left != null){
            Node rs = null;
            Node s = node.left;
            if (s.right!= null){
                rs = s.right;
                this.remove(rs);
                node.left = rs;
            }
            parent.right = s;
            System.out.println(parent.right.getData());

            s.right = node;
        }
    }

    public void transformBackBone(){
        Node temp = this.root;
        while (temp.right != null){
            preorderTraversal(root);
            System.out.println("");
            if (temp.left!=null){
                this.rightRotate(temp);
                System.out.println(findParent(temp.getData()));
            }
            else {
                temp = temp.right;
            }
        }
    }

    int findHeight(Node root){
        if(root == null){return 0;}
        return Math.max(findHeight(root.left),findHeight(root.right))+1;
    }

    public int getHeight(Node root){
        return findHeight(root)-1;
    }
}
