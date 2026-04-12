package com.asgnmt;

// MyStack implementation using MyArrayList as backing structure
// LIFO: Last In First Out
public class MyStack<T> {
    
    // Backing data structure - using ArrayList
    private MyArrayList<T> list;

    // Constructor initialize empty stack
    public MyStack() {
        list = new MyArrayList<>();
    }

    // Push item onto top of stack
    public void push(T item) {
        list.addLast(item);
    }