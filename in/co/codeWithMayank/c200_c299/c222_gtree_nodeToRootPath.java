package in.co.codeWithMayank.c200_c299;

import java.util.*;

public class c222_gtree_nodeToRootPath {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node constructGenericTree(int[] arr) {
        Node root = null;
        Stack<Node> stk = new Stack<Node>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                Node temp = new Node();
                temp.data = arr[i];

                if (stk.size() == 0) {
                    root = temp;
                } else {
                    stk.peek().children.add(temp);
                }

                stk.push(temp);
            } else {
                stk.pop();
            }
        }

        return root;
    }

    public static void displayGTree(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            displayGTree(child);
        }
    }

    public static boolean findElement(Node node, int key) {
        if (node.data == key) {
            return true;
        }

        for (Node child : node.children) {
            if (findElement(child, key)) {
                return true;
            }
        }

        return false;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int key) {
        if (node.data == key) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(node.data);
            return list;
        }

        for (Node child : node.children) {
            ArrayList<Integer> ptc = nodeToRootPath(child, key);
            if (ptc.size() > 0) {
                ptc.add(node.data);
                return ptc;
            }
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };

        Node root = constructGenericTree(arr);
        displayGTree(root);
        System.out.println("Enter the element to be searched in the tree");
        Scanner scn = new Scanner(System.in);
        int key = scn.nextInt();
        scn.close();
        if (findElement(root, key)) {
            System.out.println("Key Found");
            System.out.println("Node to root path -> "+ nodeToRootPath(root, key));
        } else {
            System.out.println("Key not Found");
        }
    }
}