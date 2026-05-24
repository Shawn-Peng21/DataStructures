package Treaps;

public class Treaps {
    class Node{
        int key;
        int priority;

        Node left;
        Node right;
        public Node(int key){
            this.key = key;
            this.priority = (int)(Math.random() * 1000);
        }
    }

    Node rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;
        return x;
    }

    Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.key) {
            root.left = insert(root.left, key);
            if (root.left.priority > root.priority) {
                root = rotateRight(root);
            }
        } else {
            root.right = insert(root.right, key);
            if (root.right.priority > root.priority) {
                root = rotateLeft(root);
            }
        }
        return root;
    }

    public boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (key == root.key) {
            return true;
        }

        if (key < root.key) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    Node delete(Node root, int key){
        if (root == null) {
            return null;
        }

        if(key < root.key){
            root.left = delete(root.left, key);
        }else if(key > root.key){
            root.right = delete(root.right, key);
        }else {
            if(root.left == null){
                return root.right;
            }

            if(root.right == null){
                return root.left;
            }

            if(root.left.priority > root.right.priority){
                root = rotateRight(root);
                root.right = delete(root.right, key);
            }else{
                root = rotateLeft(root);
                root.left = delete(root.left, key);
            }
        }
        return root;
    }
}
