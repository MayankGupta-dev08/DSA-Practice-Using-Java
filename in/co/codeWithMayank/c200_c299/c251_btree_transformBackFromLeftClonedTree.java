package in.co.codeWithMayank.c200_c299;

import java.util.*;

public class c251_btree_transformBackFromLeftClonedTree {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }

    }

    public static Node bTreeConstructor(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) { // we have to set the left node
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) { // we have to set the right node
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void displayBTree(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        displayBTree(node.left);
        displayBTree(node.right);
    }

    public static Node createLeftClonedTree(Node node) {
        if (node == null) {
            return null;
        }

        Node lcr = createLeftClonedTree(node.left);
        Node rcr = createLeftClonedTree(node.right);

        Node newNode = new Node(node.data, lcr, null);
        node.left = newNode;
        node.right = rcr;

        return node;
    }

    public static Node transformBackFromleftClonedTree(Node node) {
        if (node == null) {
            return null;
        }

        // lnn -> left normalized node and rnn -> right normalized node
        Node lnn = transformBackFromleftClonedTree(node.left.left);
        Node rnn = transformBackFromleftClonedTree(node.right);

        node.left = lnn;
        node.right = rnn;

        return node;
    }
    
    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, 40, null, null, 75, 62, 60, null, null, 70, null,
                null, 87, null, null };

        Node root = bTreeConstructor(arr);
        displayBTree(root);
        System.out.println("-----------------------");
        root = createLeftClonedTree(root);
        displayBTree(root);
        System.out.println("-----------------------");
        root = transformBackFromleftClonedTree(root);
        displayBTree(root);
    }
}