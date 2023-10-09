import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    class Node
    {
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
            left = null;
            right = null;
        }

    }

    Node root;

    BinaryTree(){
        root = null;
    }

    public void add(int value) {
        if(root == null) {
            root = new Node(value);
        } else{
            Queue<Node> nodes = new LinkedList<>();
            nodes.add(root);

            while(!nodes.isEmpty()) {
                Node current = nodes.poll();
                if (current.left == null) {
                    current.left = new Node(value);
                    break;
                } else
                    nodes.add(current.left);
                if (current.right == null) {
                    current.right = new Node(value);
                    break;
                } else {
                    nodes.add(current.right);
                }
            }
        }
    }

    public void inorder()
    {
        inorderRec(root);
    }

    private void inorderRec (Node root){
        if (root != null){
            inorderRec(root.left);
            System.out.println(root.value);
            inorderRec(root.right);
        }
    }

    public  boolean contains(int value){
        if (root == null) return false;

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            Node current = nodes.poll();

            if (current.value == value) {
                return true;
            }

            if (current.left != null) {
                nodes.add(current.left);
            }
            if (current.right != null) {
                nodes.add(current.right);
            }
        }

        return false;
    }
    public void printTree() {
        printTreeRec(root, "", true);
    }

    private void printTreeRec(Node currPtr, String indent, boolean last) {
        if (currPtr != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }
            System.out.println(currPtr.value);
            printTreeRec(currPtr.left, indent, false);
            printTreeRec(currPtr.right, indent, true);
        }
    }
    public void printPretty() {
        int height = getHeight(root);
        int spaces = (int) Math.pow(2, height+1);
        printPrettyRec(root, spaces, spaces/2);
    }

    private void printPrettyRec(Node curr, int totalSpaces, int numSpacesBetween) {
        if (curr == null) return;

        for (int i = 0; i < totalSpaces - numSpacesBetween; i++) {
            System.out.print(" ");
        }

        System.out.print(curr.value);

        for (int i = 0; i < numSpacesBetween; i++) {
            System.out.print(" ");
        }

        System.out.println();

        if (curr.left != null || curr.right != null) {
            for (int i = 0; i < totalSpaces - numSpacesBetween - 2; i++) {
                System.out.print(" ");
            }

            if (curr.left != null) {
                System.out.print("/");
            } else {
                System.out.print(" ");
            }

            for (int i = 0; i < 2*numSpacesBetween - 3; i++) {
                System.out.print(" ");
            }

            if (curr.right != null) {
                System.out.print("\\");
            }

            System.out.println();
        }

        printPrettyRec(curr.left, totalSpaces - numSpacesBetween/2, numSpacesBetween/2);
        printPrettyRec(curr.right, totalSpaces - numSpacesBetween/2, numSpacesBetween/2);
    }

    private int getHeight(Node curr) {
        if (curr == null) return 0;
        return Math.max(getHeight(curr.left), getHeight(curr.right)) + 1;
    }


}
