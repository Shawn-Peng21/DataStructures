package Hashing;

public class HashTable {
    class Node{
        String key;
        int value;
        Node next;

        Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node[] table;
    int capacity;

    HashTable(int capacity){
        this.capacity = capacity;
        table = new Node[capacity];
    }

    int hash(String key){
        return Math.abs(key.hashCode()) % capacity;
    }

    void insert(String key, int value){
        int index = hash(key);
        Node head = table[index];
        Node curr = head;

        while(curr != null){
            if(curr.key.equals(key)){
                curr.value = value;
                return;
            }
            curr = curr.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = head;
        table[index] = newNode;
    }

    Integer get(String key){
        int index = hash(key);
        Node curr = table[index];

        while(curr != null){
            if(curr.key.equals(key)){
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }

    void remove(String key){
        int index = hash(key);
        Node curr = table[index];
        Node prev = null;

        while(curr != null){

            if(curr.key.equals(key)){
                if(prev == null){
                    table[index] = curr.next;
                }else{
                    prev.next = curr.next;
                }
            }
            prev = curr;
            curr = curr.next;
        }
    }
}