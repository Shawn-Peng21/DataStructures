package DigitalTrees;

import java.util.Stack;

public class Tries<V> {
    private String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    class Node<V>{
        boolean hasKey;
        V value;
        Node<V>[] children;

        public Node(){
            this.hasKey = false;
            this.value = null;
            this.children =  new Node[ALPHABET.length()];
        }
    }

    int index(char symbol){
        return symbol - 'a';
    }

    void insert(Node<V> trie, String key, V value){
        Node<V> p = trie;
        for(int i = 0;i < key.length();i++){
            int j = index(key.charAt(i));
            if(p.children[j] == null){
                p.children[j] = new Node<V>();
            }
            p = p.children[j];
        }
        p.hasKey = true;
        p.value = value;
    }

    boolean search(Node<V> trie, String key){
        Node<V> p = trie;
        for(int i = 0;i < key.length();i++){
            int j = index(key.charAt(i));
            if(p.children[j] == null){
                return false;
            }
            p = p.children[j];
        }
        return true;
    }

    void delete(Node<V> trie, String key){
        Stack<Node<V>> stack = new Stack<>();
        Node<V> p = trie;
        for(int i = 0;i < key.length();i++){
            int j = index(key.charAt(i));
            if(p.children[j] == null){
                return;
            }
            stack.push(p);
            p = p.children[j];
        }
        p.hasKey = false;
        p.value = null;
        clean(stack, p, key);
    }

    void clean(Stack<Node<V>> stack, Node<V> p, String key){
        int k = key.length() - 1;
        while(!stack.isEmpty() && isEmptyLeaf(p)){
            Node<V> parent = stack.pop();
            parent.children[index(key.charAt(k))] = null;
            k--;
            p = parent;
        }
    }

    boolean isEmptyLeaf(Node<V> p){
        if(p.value != null){
            return false;
        }
        for(Node<V> child: p.children){
            if(child != null){
                return false;
            }
        }
        return true;
    }
}