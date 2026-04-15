package com.asgnmt;

public class MyMinHeap<T extends Comparable<T>> {

    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public boolean empty() {
        return heap.size() == 0;
    }

    public int size() {
        return heap.size();
    }

    public T getMin() {
        if (empty()) throw new IndexOutOfBoundsException();
        return heap.get(0);
    }

    public T extractMin() {
        if (empty()) throw new IndexOutOfBoundsException();

        T min = heap.get(0);
        T last = heap.getLast();

        heap.set(0, last);
        heap.removeLast();

        if (!empty()) {
            heapify(0);
        }

        return min;
    }

    public void insert(T item) {
        heap.addLast(item);
        traverseUp(heap.size() - 1);
    }
    
    private void heapify(int index) {
        int left = leftChildOf(index);
        int right = rightChildOf(index);
        int smallest = index;

        if (left < heap.size() &&
            heap.get(left).compareTo(heap.get(smallest)) < 0) {
            smallest = left;
        }

        if (right < heap.size() &&
            heap.get(right).compareTo(heap.get(smallest)) < 0) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    private void traverseUp(int index) {
        while (index > 0) {
            int parent = parentOf(index);

            if (heap.get(index).compareTo(heap.get(parent)) < 0) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private int leftChildOf(int index) {
        return 2 * index + 1;
    }

    private int rightChildOf(int index) {
        return 2 * index + 2;
    }

    private int parentOf(int index) {
        return (index - 1) / 2;
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}