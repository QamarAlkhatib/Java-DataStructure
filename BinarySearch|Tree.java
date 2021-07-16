
public class Node {

    int value;
    Node left,right;

    public Node(int val) {
        this.value = val;
        left = right = null;
    }
}


public class BST {
    Node root;

    public BST() {
        root = null;
    }

    void insert(int newValue) { // o log n

        root = insertRec(root, newValue);
    }

    private Node insertRec(Node root, int val) {

        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (val < root.value) {
            root.left = insertRec(root.left, val);
        } else if (val > root.value) {
            root.right = insertRec(root.right, val);
        }
        return root;
    }

    public void display(Node root) {
        if (root != null) {
            display(root.left);
            System.out.print(" " + root.value);
            display(root.right);
        }
    }

    boolean search(int value) { // o log n
        Node WantedVal = searchRec(root, value);

        if (WantedVal != null)
            return true;
        else
            return false;
    }

    private Node searchRec(Node root, int value) {

        if (root == null) {
            return null;
        }
        if (root.value == value) {
            return root;
        } else if (value < root.value)
            return searchRec(root.left, value);

        else
            return searchRec(root.right, value);
    }

    void printPreOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.value + " ");

        printPreOrder(node.left);

        printPreOrder(node.right);
    }

    void printInOrder(Node node) {
        if (node == null)//base case
            return;
        printInOrder(node.left);

        System.out.print(node.value + " ");

        printInOrder(node.right);
    }

    void printPostOrder(Node node) {
        if (node == null)
            return;

        printPostOrder(node.left);

        printPostOrder(node.right);

        System.out.print(node.value + " ");
    }

    void deleteNode(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {

        if (root == null) {
            return root;
        }

        if (key < root.value) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.value) {
            root.right = deleteRec(root.right, key);
        } else {
            //check if we have one child
            if (root.left == null)
                return root.right;
            
            else if (root.right == null)
                return root.left;

            root.value = findMin(root.right);
            //after finding the min value in the right subtree, i delete it normally
            root.right = deleteRec(root.right, root.value);
        }
        return root;
    }

    int findMin(Node root) {

        int min = root.value;
        while (root.left != null) {

            min = root.left.value;
            root = root.left;
        }
        return min;
    }
}


public class Main {

    public static void main(String[] args) {

        BST tree = new BST();
        tree.insert(8);
        tree.insert(15);
        tree.insert(0);
        tree.insert(9);
        tree.insert(3);
        tree.display(tree.root);

        System.out.println();
        System.out.println(tree.search(8));
        System.out.println(tree.search(15));
        System.out.println(tree.search(4));
        System.out.println(tree.search(3));
    
    
//        tree.root = new Node(1);
//        tree.root.left = new Node(2);
//        tree.root.right = new Node(3);
//        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(5);
//
//        System.out.println(
//                "Preorder traversal of binary tree is ");
//        tree.printPreOrder(tree.root);
//
//        System.out.println(
//                "\nInorder traversal of binary tree is ");
//        tree.printInOrder(tree.root);
//
//        System.out.println(
//                "\nPostorder traversal of binary tree is ");
//        tree.printPostOrder(tree.root);
    }
}
