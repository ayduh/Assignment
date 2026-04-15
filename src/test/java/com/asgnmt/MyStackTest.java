package com.asgnmt;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack<Integer> al = new MyStack<>();
        System.out.println(al.empty());
        al.push(2);
        System.out.println(al.empty());
        System.out.println(al.peek());
        al.pop();
        System.out.println(al.empty());
        al.peek();
    }
}
