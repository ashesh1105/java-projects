package com.datastructures.heaps;

import java.util.Arrays;

public class MaxHeap {

    private int capacity = 10;

    private int size = 0;

    int[] items = new int[capacity];

    public int getSize() {
        return size;
    }

    private int leftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int rightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return parentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private int parent(int index) {
        return items[parentIndex(index)];
    }

    // swap elements
    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    // ensure capacity
    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    // Peek an item
    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    // Poll an item
    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    // Add an item

    public void add(int item) {
        ensureExtraCapacity();
        items[size++] = item;
        heapifyUp();
    }

    private void heapifyDown() {

        int index = 0;

        while (hasLeftChild(index)) {
            int largerChildIndex = leftChildIndex(index);

            if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                largerChildIndex = rightChildIndex(index);
            }

            //Finally swap, if item is more than it's smaller parent
            if (items[index] > items[largerChildIndex]) {
                break;  // This is important to avoid infinite loop
            } else {
                swap(index, largerChildIndex);
            }
            index = largerChildIndex;
        }
    }

    private void heapifyUp() {

        int index = size - 1;
        while (hasParent(index) && parent(index) < items[index]) {
            int parentIndex = parentIndex(index);
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    // main method
    public static void main(String[] args) {

        MaxHeap maxHeap = new MaxHeap();

        maxHeap.add(10);
        maxHeap.add(2);
        maxHeap.add(20);
        maxHeap.add(5);
        maxHeap.add(15);
        maxHeap.add(8);
        maxHeap.add(13);

        System.out.println("Maximum element in MaxHeap: " + maxHeap.peek());
        System.out.println("Poll an element from MaxHeap: " + maxHeap.poll());
        System.out.println("Now if you peek the MaxHeap, you get: " + maxHeap.peek());

    }
}
