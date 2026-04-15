package com.asgnmt;


// Queue implementation using LinkedList
// FIFO: First In First Out
public class MyQueue<T> {
    private MyLinkedList<T> list;

    public MyQueue(){
        list = new MyLinkedList<>();
    }

    // size
    public int size(){
        return list.size();
    }

    public T peek(){
        if (list.size() == 0){throw new IndexOutOfBoundsException();}
        return list.getLast();
    }

    public void enqueue(T item){
        list.addLast(item);
    }

    public T dequeue(){
        if (list.size() == 0){throw new IndexOutOfBoundsException();}
        T lastItem = list.getLast();
        list.removeLast();
        return lastItem;
    }

    public boolean empty(){
        return list.size() == 0;
    }
}
