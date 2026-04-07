package Stack;

public class Stack<T>{
    private T[] stack;
    private int capacity;

    public Stack(T[] stack, int capacity){
        this.stack = stack;
        this.capacity = capacity;
    }

    int getSize(){
        return stack.length;
    }

    boolean isEmpty(){
        if(stack.length == 0){
            return true;
        }
        return false;
    }

    void push(T element){
        if(stack.length - 1 == capacity){
            throw new IndexOutOfBoundsException("Stack is full.");
        }
        stack[stack.length]= element;
    }

    T pop(){
        if(isEmpty()){
            throw new IllegalStateException("Stack has no element.");
        }
        T value = stack[stack.length - 1];
        return value;
    }

    T peek(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty.");
        }
        return stack[stack.length - 1];
    }
}
