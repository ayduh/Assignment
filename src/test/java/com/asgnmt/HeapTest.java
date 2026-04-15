package com.asgnmt;

public class HeapTest{
    public static void main(String[] args) {
    MyMinHeap<Integer> heap = new MyMinHeap<>();

    heap.insert(10);
    heap.insert(5);
    heap.insert(20);
    heap.insert(2);

    System.out.println(heap.getMin()); // 2

    while (!heap.empty()) {
        System.out.println(heap.extractMin());
    }
}
}
