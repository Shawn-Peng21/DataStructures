package Stack;

public class Stack<T>{
    private T[] stack;
    private int top;
    private int capacity;

    public Stack(T[] stack, int capacity, int top){
        this.stack = stack;
        this.capacity = capacity;
        this.top = 0;
    }

    int getSize(){
        return top;
    }

    boolean isEmpty(){
        if(top == 0){
            return true;
        }
        return false;
    }

    void push(T element){
        if(top == capacity){
            throw new IndexOutOfBoundsException("Stack is full.");
        }
        top++;
        stack[top] = element;
    }

    T pop(){
        if(isEmpty()){
            throw new IllegalStateException("Stack has no element.");
        }
        T value = stack[top];
        return value;
    }

    T peek(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty.");
        }
        return stack[top];
    }
}
