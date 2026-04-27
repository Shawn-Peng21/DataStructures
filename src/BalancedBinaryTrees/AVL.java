package BalancedBinaryTrees;

public class AVL<T> {
    class Node<T>{
        Node<T> left;
        int value;
        Node<T> right;
        int height;

        Node(int value){
            this.value = value;
            this.height = 1;
        }
    }

    int height(Node<T> p){
        if(p == null){
            return 0;
        }else{
            return p.height;
        }
    }

    void updateHeight(Node<T> p){
        if(p != null){
            p.height = 1 + Math.max(height(p.left), height(p.right));
        }
    }

    Node<T> rotateLeft(Node<T> p){
        Node<T> B = p.right.left;
        Node<T> q = p.right;
        q.left = p;
        q.left.right = B;
        updateHeight(q.left);
        updateHeight(q);
        return q;
    }

    Node<T> rotateRight(Node<T> p) {
        Node<T> B = p.left.right;
        Node<T> q = p.left;
        q.right = p;
        q.right.left = B;
        updateHeight(q.right);
        updateHeight(q);
        return q;
    }

    Node<T> double_rotate_left(Node<T> p){
        p.right = rotateRight(p.right);
        return rotateLeft(p);
    }

    Node<T> double_rotate_right(Node<T> p){
        p.left = rotateLeft(p.left);
        return rotateRight(p);
    }

    Node<T> rebalance(Node<T> p) {
        if (height(p.right) > height(p.left) + 1) {
            if (height(p.right.right) >= height(p.right.left)) {
                p = rotateLeft(p);
            } else {
                p = double_rotate_left(p);
            }
        } else if (height(p.left) > height(p.right) + 1) {
            if(height(p.left.left) >= height(p.left.right)){
                p = rotateRight(p);
            } else {
                p = double_rotate_right(p);
            }
        }
        return p;
    }

    Node<T> insert(Node<T> p, int x){
        if(p == null){
            return new Node<T>(x);
        }else if(x == p.value){
            return p;
        }else if(x < p.value){
            p.left = insert(p.left, x);
        }else{
            p.right = insert(p.right, x);
        }
        updateHeight(p);
        p = rebalance(p);
        return p;
    }


}