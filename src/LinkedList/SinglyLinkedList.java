package LinkedList;

public class SinglyLinkedList<T> {

    private static class Node<T>{
        T element;
        private Node<T> next;

        private Node(T element){
            this.element = element;
            this.next = null;
        }
    }

    private int size;
    private Node<T> head;

    public SinglyLinkedList(Node<T> head, int size){
        this.size = 0;
        this.head = null;
    }

    void addFirst(T element){
        Node<T> newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    void addLast(T element){
        Node<T> newNode = new Node(element);
        if(head == null){
            head = newNode;
        }else{
            Node<T> curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }

    void printList(){
        Node<T> curr = head;
        while(curr.next != null){
            System.out.print(curr.element + "->");
            curr = curr.next;
        }
        System.out.print("null");
    }

    void removeFirst(){
        if(head == null){
            return;
        }
        head = head.next;
        size--;
    }

    int getSize(){
        return size;
    }

    T obtain(int i){
        Node<T> curr = head;
        int j = 0;
        while(j < i){
            curr = curr.next;
            j++;
        }
        return curr.element;
    }

    void add(T element, int i){
        if(i < 0 || i > size){
            throw new IllegalStateException("Index out of range.");
        }

        if(i == 0){
            addFirst(element);
            return;
        }

        int j = 0;
        Node<T> curr = head;
        while(j < i){
            curr = curr.next;
        }

        Node<T> newNode = new Node<>(element);
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }

    void romove(int i){
        if(i < 0 || i > size){
            throw new IllegalStateException("Index out of range.");
        }

        if(i == 0){
            removeFirst();
            return;
        }

        int j = 0;
        Node<T> curr = head;
        while(j < i){
            curr = curr.next;
        }

        curr.element = null;
        size--;
    }
}