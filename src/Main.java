import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
     BinaryTree tree = new BinaryTree();
     ArrayList<Integer> list = new ArrayList<Integer>();
     list.add(1);
        list.add(2);

        list.add(3);

        list.add(4);

        list.add(5);

        list.add(6);


        for (int elem:list) {
            tree.add(elem);
        }

        tree.inorder();
        tree.printTree();
        tree.printPretty();
    }

}