package Heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap<T extends Comparable<T>> {
    private List<T> heap;

    public MaxHeap(){
        heap = new ArrayList<>();
    }

    boolean isRoot(int i){
        return i == 0;
    }

    boolean inRange(ArrayList<T> heap, int i){
        return 0 <= i && i < heap.size();
    }

    int size(){
        return heap.size();
    }

    boolean isEmpty(){
        return heap.isEmpty();
    }

    int leftChild(int i){
        return 2 * i + 1;
    }

    int rightChild(int i){
        return 2 * i + 2;
    }

    int parent(int i){
        return (i - 1) / 2;
    }

    void swap(int i, int j){
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    T peek(){
        if(heap.isEmpty()){
            throw new RuntimeException("Heap is empty.");
        }
        return heap.get(0);
    }

    void siftUp(ArrayList<T> heap, int i){
        while(!isRoot(i) && heap.get(i).compareTo(heap.get(parent(i))) > 0){
            swap((int)heap.get(i), (int)heap.get(parent(i)));
            i = parent(i);
        }
    }

    void insert(int i){
        while (i > 0) {
            int parent = parent(i);

            if (heap.get(parent).compareTo(heap.get(i)) >= 0) {
                return;
            }
            swap(i, parent);
            i = parent;
        }
    }

    void siftDown(ArrayList<T> heap, int i){
        int size = heap.size();

        while(true){
            int left = leftChild(i);
            int right = rightChild(i);
            int largest = i;

            if(left < size && heap.get(left).compareTo(heap.get(largest)) > 0){
                largest = left;
            }

            if(right < size && heap.get(right).compareTo(heap.get(largest)) > 0){
                largest = right;
            }

            if(largest == i){
                return;
            }

            swap(largest, i);
            i = largest;
        }
    }

    T removeMax(){
        if(heap.isEmpty()){
            throw new RuntimeException("Heap is empty.");
        }

        T max = heap.get(0);
        T last = heap.remove(heap.size() - 1);

        if(!heap.isEmpty()){
            heap.set(0, last);
            siftDown((ArrayList<T>) heap, 0);
        }
        return max;
    }
}