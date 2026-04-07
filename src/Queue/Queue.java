package Queue;

public class Queue<T> {
    private T[] queue;
    private int front;
    private int rear;
    private int capacity;

    public Queue(int front, int rear, int capacity){
        this.front = 0;
        this.rear = 0;
        this.capacity = capacity;
    }

    int getSize(){
        return (rear - front + capacity) % capacity;
    }

    boolean isEmpty(){
        if(front == rear){
            System.out.println("The queue is empty.");
            return true;
        }
        return false;
    }

    boolean isFull(){
        if(front == (rear + 1) % capacity){
            System.out.println("The queue is already full.");
            return true;
        }
        return false;
    }

    T peek(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty.");
        }
        return queue[front];
    }

    void enqueue(T element){
        if(isFull()){
            throw new IllegalStateException("Queue is full of elements.");
        }
        queue[rear] = element;
        rear = (rear + 1) % capacity;
    }

    T dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("The queue is empty, we don't have any element to move.");
        }
        T value = queue[front];
        front = (front + 1) % capacity;
        return value;
    }
}
