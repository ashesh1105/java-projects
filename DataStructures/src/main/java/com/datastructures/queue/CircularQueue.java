package com.datastructures.queue;

public class CircularQueue {

    private int head;
    private int tail;
    private int capacity;
    private int[] array;

    public CircularQueue(int capacity) {

        this.capacity = capacity;
        array = new int[capacity];
        head = 0;
        tail = 0;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public int size() {
        return (capacity - head + tail) % capacity;
    }

    public void enqueue(int element) {

        if ((tail + 1) % capacity == head) {
            resize();
        }
        array[tail] = element;
        tail = (tail + 1) % capacity;

    }

    public int dequeue() {

        // If size is zero, log and return
        if (size() == 0) {
            throw new IllegalStateException("Queue is empty, can't dequeue at this stage!");
        }
        int removedCandidate = array[head];
        head = (head + 1) % capacity;
        return removedCandidate;
    }

    private void resize() {

        int newMaxCapacity = 2 * capacity;
        int[] arr = new int[newMaxCapacity];
        int pos = 0;
        while (!(head == tail)) {
            arr[pos++] = array[head];
            head = (head + 1) % capacity;
        }
        capacity = newMaxCapacity;
        array = arr;
        head = 0;
        tail = pos;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("CircularQueue [head=" + head + ", tail=" + tail
                + ", capacity=" + capacity + ", elements=[");
        int i = head;
        while (i != tail) {

            if ((i + 1 != tail)) {
                sb.append(array[i] + ", ");
            } else {
                sb.append(array[i] + "]]");
            }
            i = (i + 1) % capacity;
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        CircularQueue cq = new CircularQueue(5);
        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);
        cq.enqueue(4);
        System.out.println(cq.toString());
        System.out.println("Dequeue " + cq.dequeue() + ":");
        System.out.println(cq.toString());
        System.out.println("Queue size: " + cq.size());

        System.out.println("Add couple of more elements to this queue.");
        cq.enqueue(5);
        cq.enqueue(6);
        System.out.println("Print the queue again: " + cq.toString());
        System.out.println("Queue size now: " + cq.size());

        System.out.println("\nLet's dequeue all elements now.");
        System.out.println("Dequeue: " + cq.dequeue());
        System.out.println("Dequeue: " + cq.dequeue());
        System.out.println("Dequeue: " + cq.dequeue());
        System.out.println("Dequeue: " + cq.dequeue());
        System.out.println("Dequeue: " + cq.dequeue());
        System.out.println("Size of the queue now: " + cq.size());
        System.out.println("What will happen if we try to Dequeue now? It should cause an error, right?");
        cq.dequeue();

    }

}
