package com.datastructures.queue;

public class CircularQueue {

	private int head;
	private int tail;
	private int maxCapacity;
	private int[] array;

	public CircularQueue(int maxCapacity) {

		this.maxCapacity = maxCapacity;
		array = new int[maxCapacity];
		head = 0;
		tail = 0;
	}

	public boolean isEmpty() {
		return head == tail;
	}

	public int size() {
		return (maxCapacity - head + tail) % maxCapacity;
	}

	public void enqueue(int element) {

		if ((tail + 1) % maxCapacity == head) {
			resize();
		}
		array[tail] = element;
		tail = (tail + 1) % maxCapacity;

	}

	public int dequeue() {
		int removedCandidate = array[head];
		head = (head + 1) % maxCapacity;
		return removedCandidate;
	}

	private void resize() {

		int newMaxCapacity = 2 * maxCapacity;
		int[] arr = new int[newMaxCapacity];
		int pos = 0;
		while (!(head == tail)) {
			arr[pos++] = array[head];
			head = (head + 1) % maxCapacity;
		}
		maxCapacity = newMaxCapacity;
		array = arr;
		head = 0;
		tail = pos;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("CircularQueue [head=" + head + ", tail=" + tail
				+ ", maxCapacity=" + maxCapacity + ", elements=[");
		int i = head;
		while (i != tail) {

			if ((i + 1 != tail)) {
				sb.append(array[i] + ", ");
			} else {
				sb.append(array[i] + "]]");
			}
			i = (i + 1) % maxCapacity;
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		CircularQueue cq = new CircularQueue(5);
		cq.enqueue(1);
		cq.enqueue(2);
		cq.enqueue(3);
		cq.enqueue(4);
		cq.enqueue(5);
		System.out.println(cq.toString());
		System.out.println("Dequeue " + cq.dequeue() + ":");
		System.out.println(cq.toString());
		System.out.println("Queue size: " + cq.size());

	}

}
