package DataStructures.BinaryTree;

import java.util.*;

//saves the vertical sum of the binary  tree
class VerticalSum {

    //hashmap for vertical sums key is the vertical distance from root and value is the sum
    private HashMap<Integer, Integer> verticalSums;

    VerticalSum() {
        this.verticalSums = new HashMap<>();
    }

    public void addSum(int num, int verticalLine){
        verticalSums.merge(verticalLine, num, Integer::sum);

    }

    public void getVerticalSums(){
        for(Map.Entry<Integer, Integer> entry : verticalSums.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println("Vertical line: " + key + " Sum: " + value);
        }
    }
}

//result array for subtree assignment
class ResultArray {
    public ArrayList<Node> values = new ArrayList<>();

    public void addValues(Node i){
        values.add(i);
    }

    public List<Node> getNodes (){
        return values;
    }

    public List<Integer> getValues(){
        List<Integer> ints = new ArrayList<>();
        for (Node n : values){
            ints.add(n.value);
        }
        return ints;
    }
}


class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int val) {
        value = val;
        left = null;
        right = null;
    }
}

//binary tree
class BinaryTree {
    public Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int value) {
        Node new_node = new Node(value);
        if (root == null) {
            root = new_node;
        } else {
            Node current_node = root;
            while (true) {
                if (current_node.left == null) {
                    current_node.left = new_node;
                    break;
                } else if (current_node.right == null) {
                    current_node.right = new_node;
                    break;
                } else {
                    current_node = current_node.left;
                }
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        ResultArray arr = new ResultArray();

        //binary tree
        //        1
        //     2     3
        //   4  5     10
        //  6 7
        BinaryTree tree = new BinaryTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.root.right.right = new Node(10);


        //is subtree
        //      2
        //    4   5
        //  6   7
        BinaryTree subtree = new BinaryTree();
        subtree.insert(2);
        subtree.insert(4);
        subtree.insert(5);
        subtree.insert(6);
        subtree.insert(7);

        //is not subtree
        //      6
        //    10  11
        BinaryTree notSubtree = new BinaryTree();
        notSubtree.insert(6);
        notSubtree.insert(10);
        notSubtree.insert(11);


        //is not subtree and no same number
        BinaryTree notSubtree2 = new BinaryTree();
        notSubtree2.insert(100);
        notSubtree2.insert(20);
        notSubtree2.insert(11);

        //check if is subtree -> correct
        System.out.println("correct Subtree is subtree: " + isSubTree(tree, subtree));
        System.out.println("incorrect Subtree is subtree: " + isSubTree(tree, notSubtree));
        System.out.println("inccorrect Subtree is subtree: " + isSubTree(tree, notSubtree2));

        System.out.println("\n");


        VerticalSum sum = new VerticalSum();

        verticalSums(tree.root, 0, sum);

        //print vertical sum of binary tree -> correct
        System.out.println("Vertical sum of tree: ");
        sum.getVerticalSums();

        System.out.println("\n");

        //print right view
        System.out.println("Rightview: ");
        rightView(tree.root);

        System.out.println("\n");


        //unbalanced tree
        System.out.println("isBalanced: " + balancedTree(tree.root));

        //balanced tree
        System.out.println("isBalanced: " + balancedTree(subtree.root));

        System.out.println("\n");

        //list per level
        listPerLeve(tree.root);


    }


    //t1 sub_tree
    public static boolean isSubTree(BinaryTree q, BinaryTree p){
        ResultArray arr = new ResultArray();

        Node n = checkSameValue(q, p, arr);

        if(n == null){
            return false;
        }

        ResultArray arr2 = new ResultArray();
        ResultArray arr3 = new ResultArray();

        preorder(n, arr2);
        preorder(p.root, arr3);

        if(arr2.getValues().equals(arr3.getValues())){
            return true;
        }
        return false;
    }


    //does preorder sort in an array
    public static void preorder(Node n, ResultArray arr){
        if(n == null){
            return;
        }
        arr.addValues(n);
        preorder(n.left, arr);
        preorder(n.right, arr);

    }

    //checks if tree p has value of tree q's root
    public static Node checkSameValue(BinaryTree p, BinaryTree q, ResultArray arr){
        preorder(p.root, arr);
        List<Node> list = arr.getNodes();

        for (Node i : list){
            if(i.value == q.root.value){
                return i;
            }
        }

        return null;

    }




    //T. Vertical sums
    //Node startnode, line vertical line, vertical sum class to save the sums to
    public static void verticalSums(Node node, int line, VerticalSum sum){
        if (node == null){
            return;
        }
        sum.addSum(node.value, line);
        verticalSums(node.left, line - 1, sum);
        verticalSums(node.right, line + 1, sum);
    }




    //T. Binary tree right view

    public static void rightView(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.value);
        rightView(node.right);

    }





    //checks if tree is balanced
    public static boolean balancedTree(Node root){
        if(root == null){
            return true;
        }
        if(root.left == null){
            if(nodeDepth(root.right) > 1){
                return false;
            }
        }
        if(root.right == null){
            if(nodeDepth(root.left) > 1){
                return false;
            }
        }
        int leftHeight = nodeDepth(root.left);
        int rightHeight = nodeDepth(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }

        return true;
    }

    //calculates tree height
    public static int nodeDepth(Node node){
        if(node == null){
            return 0;
        }

        int left = nodeDepth(node.left);
        int right = nodeDepth(node.left);

        return Math.max(left, right) + 1;

    }

    public static void listPerLeve(Node root){
        int depth = nodeDepth(root);
        List<List> lists = new ArrayList<>();

        for(int i = 0; i < depth; i++){
            List<Integer> list = new ArrayList<>();
            lists.add(list);
        }

        addNextLevel(root, lists, 0);

        for(List<Integer> list : lists){
            System.out.println("Next level: ");
            for (Integer i : list){
                System.out.println(i);

            }
        }

    }

    public static void addNextLevel(Node node, List<List> lists, int index){

        if(node == null){
            return;
        }

        lists.get(index).add(node.value);

        index++;

        addNextLevel(node.left, lists, index);
        addNextLevel(node.right, lists, index);

    }
}
