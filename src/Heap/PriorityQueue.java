package Heap;

public class PriorityQueue<T extends Comparable<T>> {
    private MaxHeap<T> heap;

    public PriorityQueue(){
        heap = new MaxHeap<>();
    }

    void push(T value){
        heap.insert((int)value);
    }

    T pop(){
        return heap.removeMax();
    }

    T peek(){
        return heap.peek();
    }

    int size(){
        return heap.size();
    }

    boolean isEmpty(){
        return heap.isEmpty();
    }
}