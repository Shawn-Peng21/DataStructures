package BST;

import java.util.Stack;

public class BST<T>{
    class Node<T>{
        private Node<T> left;
        private int value;
        private Node<T> right;

        public Node(Node<T> left, int value, Node<T> right){
            this.left = left;
            this.value = value;
            this.right = right;
        }
    }

    int sum(Node<T> root){
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);

        int sum = 0;
        while(stack.size() > 0){
            Node<T> tree = stack.pop();
            if(tree != null){
                sum = sum + tree.value;
                stack.push(tree.left);
                stack.push(tree.right);
            }
        }
        return sum;
    }

    int height(Node<T> root){
        if(root == null){
            return 0;
        }else{
            return 1 + Math.max(height(root.left), height(root.right));
        }
    }

    boolean search(Node<T> root, int value){
        if(root == null){
            return false;
        }else if(root.value == value){
            return true;
        }else if(value < root.value){
            return search(root.left, value);
        }else{
            return search(root.right, value);
        }
    }

    Node<T> insert(Node<T> tree, int value){
        if(tree == null){
            return new Node(null, value, null);
        }else if(tree.value == value){
            return tree;
        }else if(value < tree.value){
            tree.left = insert(tree.left, value);
            return tree;
        }else{
            tree.right = insert(tree.right, value);
            return tree;
        }
    }

    int findMin(Node<T> tree){
        while(tree.left != null){
            tree = tree.left;
        }
        return tree.value;
    }

    Node<T> delete(Node<T> tree, int value){
        if(tree == null){
            return null;
        }else if(tree.value < value){
            return delete(tree.right, value);
        }else if(tree.value > value){
            return delete(tree.left, value);
        }else{
            if(tree.left == null){
                return tree.right;
            }
            if(tree.right == null){
                return tree.left;
            }

            tree.value = findMin(tree.right);
            tree.right = delete(tree.right, tree.value);
        }
        return tree;
    }
}