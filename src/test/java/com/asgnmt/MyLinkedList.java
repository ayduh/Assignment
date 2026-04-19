package com.asgnmt;


public class MyLinkedList<T> implements MyListInter<T> {
    
    // Reference to the first node in the list
    private Node<T> head;
    //Reference to the last node in the list
    private Node<T> tail;
    //Number of elements currently in the list
    private int size;
    
    // Constructs an empty doubly linked list
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

     //Private inner class representing a node in the doubly linked list
    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Appends the specified element to the end of this list
    @Override
    public void add(T item) {
        addLast(item);
    }

    // Inserts the specified element at the beginning of this list
    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        enforceListBoundaries(); // Prevents accidental loop
    }

    //Appends the specified element to the end of this list
    @Override
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);
        if (tail == null) {
            head = tail = newNode;
        } 
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        enforceListBoundaries();
    }

     // Inserts the specified element at the specified position in this list.
     //shifts the element currently at that position (if there is any) and any subsequent
     //elements to the right (adds one to their indixes0
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            addFirst(item);
        }
        if (index == size) {
            addLast(item);
        }

        Node<T> newNode = new Node<>(item);
        Node<T> current = getNode(index);
        Node<T> previous = current.prev;

        // Link insertion safely
        previous.next = newNode;
        newNode.prev = previous;
        newNode.next = current;
        current.prev = newNode;
        size++;
        enforceListBoundaries();
    }

    // Helper method to retrieve a node at a specific index.
    // Optimized to traverse from head or tail depending on which is closer
    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    // Replaces the element at the specified position with the specified element
    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        getNode(index).data = item;
    }

    // Returns the element at the specified position
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return getNode(index).data;
    }

    // Returns the first element in this list
    @Override
    public T getFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        return head.data;
    }

    // Returns the last element in this list
    @Override
    public T getLast() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }
        return tail.data;
    }

    // Removes the element at the specified position in this list
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> target = getNode(index);

        if (target == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null; // List became empty
        } else if (target == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
            else head = null;
        } else {
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }

        // Sever all references from the removed node to prevent memory leaks and loops
        target.next = null;
        target.prev = null;
        target.data = null;
        size--;
    }

    // Removes and returns the first element from this list
    @Override
    public void removeFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        remove(0);
    }

    // Removes and returns the last element from this list
    @Override
    public void removeLast() {
        if (tail == null) throw new IllegalStateException("List is empty");
        remove(size - 1);
    }

     //Returns the index of the first appearance of the specified element,
     //or -1 if this list does not contain the element
    @Override
    public int indexOf(Object object) {
        int index = 0;
        Node<T> current = head;
        while (current != null) {
            if (object == null ? current.data == null : object.equals(current.data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

     // Returns the index of the last appearance of the specified element,
     // or -1 if this list does not contain the element.
    @Override
    public int lastIndexOf(Object object) {
        int index = size - 1;
        Node<T> current = tail;
        while (current != null) {
            if (object == null ? current.data == null : object.equals(current.data)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    // Returns true if this list contains the specified element
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    // Returns an array containing all of the elements in this list in proper squence
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    // Removes all elements from this list
    @Override
    public void clear() {
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next;
            current.next = null;
            current.prev = null;
            current.data = null;
            current = next;
        }
        head = null;
        tail = null;
        size = 0;
    }

    // Returns the number of elements in this list
    @Override
    public int size() {
        return size;
    }

     // Sorts this list in ascending order using an in-place selection sort.
     // Assumes that elements implement Comparable
    @Override
    public void sort() {
        if (size < 2) return;
        
        Node<T> i = head;
        while (i != null && i.next != null) {
            Node<T> minNode = i;
            Node<T> j = i.next;
            while (j != null) {
                if (((Comparable<T>) minNode.data).compareTo(j.data) > 0) {
                    minNode = j;
                }
                j = j.next;
            }
            // Swap values if a smaller element was found
            if (minNode != i) {
                T temp = i.data;
                i.data = minNode.data;
                minNode.data = temp;
            }
            i = i.next;
        }
    }

     //loop prevention
    private void enforceListBoundaries() {
        if (head != null) head.prev = null;
        if (tail != null) tail.next = null;
    }
}