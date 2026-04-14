package LinkedList;

public class DoubleLinkedList<T> {
    class Node<T>{
        Node<T> prev;
        T element;
        Node<T> next;

        public Node(Node<T> prev, T element, Node<T> next){
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }

    private int size;
    private Node<T> head;
    private Node<T> tail;

    int getSize(){
        return size;
    }

    void addFirst(T element){
        Node<T> newNode = new Node(null, element, null);

        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    void addLast(T element){
        Node<T> newNode = new Node(null, element, null);

        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    void remove(int i){
        if(i < 0 || i >= size){
            throw new IllegalStateException("Index out of range");
        }

        if(i <= size - i){
            Node<T> curr = head;
            int j = 0;
            while(j < i) {
                curr = curr.next;
                j++;
            }
            Node<T> node1 = curr.prev;
            Node<T> node2 = curr.next;

            node1.next = node2;
            node2.prev = node1;
        }else{
            Node<T> curr = tail;
            int j = 0;
            while(j < size - i - 1){
                curr = curr.prev;
                j++;
            }
            Node<T> node1 = curr.prev;
            Node<T> node2 = curr.next;

            node1.next = node2;
            node2.prev = node1;
        }
        size--;
    }

    T obtain(int i){
        if(i < 0 || i >= size){
            throw new IllegalStateException("Index out of range.");
        }

        if(i <= size - i) {
            Node<T> curr = head;
            int j = 0;
            while (j < i) {
                curr = curr.next;
                j++;
            }

            return curr.element;
        }else{
            Node<T> curr = tail;
            int j = 0;
            while(j < size - i - 1){
                curr = curr.prev;
                j++;
            }

            return curr.element;
        }
    }

    void insert(int i, T element){
        if(i < 0 || i >= size){
            throw new IllegalStateException("Index out of range");
        }

        if(i <= size - i){
            Node<T> newNode = new Node<>(null, element, null);

            int j = 0;
            Node<T> curr = head;
            while(j < i){
                curr = curr.next;
                j++;
            }

            newNode.next = curr;
            curr.prev = newNode;
        }else{
            Node<T> newNode = new Node<>(null, element, null);

            int j = 0;
            Node<T> curr = tail;
            while(j < size - i - 1){
                curr = curr.prev;
                j++;
            }

            newNode.next = curr;
            curr.prev = newNode;
        }
        size++;
    }
}