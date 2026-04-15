package com.asgnmt;

// MyStack implementation using MyArrayList as backing structure
// LIFO: Last In First Out
public class MyStack<T> {
    
    // Stack data structure using ArrayList
    private MyArrayList<T> list;

    // Constructor initialize empty stack
    public MyStack() {
        list = new MyArrayList<>();
    }

    // Push item onto top of stack
    public void push(T item) {
        list.addLast(item);
    }

    // Remove the last and return (pop)
    public T pop(){
        if (list.size() == 0){throw new IndexOutOfBoundsException();}
        T lastItem = list.getLast();
        list.removeLast();
        return lastItem;
    }

    // Return the last element
    public T peek(){
        if (list.size() == 0){throw new IndexOutOfBoundsException();}
        return list.getLast();
    }

    // Return the size of the array
    public int size(){
        return list.size();
    }

    // Check if stack is empty
    public boolean empty(){
        return list.size() == 0;
    }
}