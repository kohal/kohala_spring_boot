package com.reflex.service.lisp.algorithm;

/**
 * @author: xuyj
 * @date: 2018/9/6
 */
public class Bst {

    Node root;



    static class Node{
        int value;

        Node left;

        Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left) {
            this.value = value;
            this.left = left;
        }
    }


    void insertNode(int val) {

        if (this.root == null) {
            root = new Node(val);
            return;
        }

        Node parent = findParent(root, val);

        if(val<parent.value){
            parent.left = new Node(val);
        }else {
            parent.right = new Node(val);
        }


    }

    Node findParent(Node root,int value) {
        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;
            if (value < parent.value) {
                current = parent.left;
            }else {
                current = parent.right;
            }
        }
        return parent;


    }


    void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.value);
            inOrder(root.right);

        }
    }


    public static void main(String[] args) {
        Bst bst = new Bst();
        int[] intArr = new int[]{ 6, 3, 2, 9, 5, 4, 1, 8, 7};

        for (int i = 0; i < intArr.length; i++) {
            bst.insertNode(intArr[i]);
        }


        bst.inOrder(bst.root);


    }

}
