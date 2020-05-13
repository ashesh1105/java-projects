package com.datastructures.heaps;

import java.util.Arrays;

/**
 A common situation comes during many use cases to maintain the top K elements at anytime. Examples can be:
 - Top K items sold on an eCommerce Website
 - Tok K liked or viewed videos on a Video Sharing app like YouTube
 - Top K clicked keywords on Advertisement / Recommendations Engine app
 - Top K clicked Search Results on a Search Engine / AutoSearch / Type ahead app, etc.

 Given Billions of Requests per unit of time, how we we maintain such a list handy at anytime?
 Above is more of a System Design Problem but that bigger problem will need a low level implementation of an
 algorithm that can give us Top K Objects at anytime locally on a Server, right? This is demonstrated below.

 We will achieve the objectives of this algorithm by designing a Min Heap of size K. Anytime there's an add request
 and size is full, we will:
    A) peak the Min Heap to get minimum element from the Heap.
    B) Check if new element is more than min element in the Heap, if not, then ignore the add request.
    C) poll the Min Heap, meaning remove the minimum element from it and then add the new element.
    D) Code an API to return top K elements anytime, which will be the underlying data itself, array in our case

 */

public class TopKElementsWithMinHeap {

    private Integer[] heapData;
    private int capacity;
    private int currentPosition = -1;

    public TopKElementsWithMinHeap(int capacity) {
        this.capacity = capacity;
        heapData = new Integer[capacity];
    }

    public Integer peak() {
        return heapData[0];
    }

    public int size() {
        return currentPosition;
    }

    public void add(Integer[] data) {

        for(Integer elem : data) {

            // If capacity is full, remove the existing minimum only if new one is larger
            if (currentPosition >= capacity - 1) {
                if (elem > heapData[0]) {
                    Integer polledData = poll();
                    System.out.println("Removing " + polledData + " from the heap and adding " + elem);
                } else {
                    continue;   // Not breaking the loop here to get to more of input array elements
                }
            }

            heapData[++currentPosition] = elem;
            fixUp(currentPosition);
        }
    }

    // Note here, a child can have only one parent, so fixUp is straight forward
    private void fixUp(int index) {

        int parentIndex = (index - 1) / 2;

        while (parentIndex >= 0 && heapData[index] < heapData[parentIndex]) {
            Integer temp = heapData[parentIndex];
            heapData[parentIndex] = heapData[index];
            heapData[index] = temp;
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    public Integer poll() {

        Integer polledData = heapData[0];

        heapData[0] = heapData[currentPosition--];
        heapData[currentPosition +1] = null;
        fixDown(0);

        return polledData;
    }

    // Fixing Down goes a bit complex since parent can be compared and swapped only with the smaller child!
    private void fixDown(int index) {

        int upto = currentPosition;

        while (index < upto) {

            int childIndexToSwap;
            int leftChildIndex = 2*index + 1;
            int rightChildIndex = 2*index + 2;

            if (leftChildIndex <= upto) {

                if (rightChildIndex > upto) {
                    childIndexToSwap = leftChildIndex;
                } else {
                    childIndexToSwap = (heapData[leftChildIndex] < heapData[rightChildIndex] ? leftChildIndex : rightChildIndex);
                }

                if (heapData[index] > heapData[childIndexToSwap]) {
                    Integer temp = heapData[index];
                    heapData[index] = heapData[childIndexToSwap];
                    heapData[childIndexToSwap] = temp;
                    index = childIndexToSwap;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    public String toString() {
        return Arrays.deepToString(this.heapData);
    }

    public static void main(String[] args) {

        TopKElementsWithMinHeap heap = new TopKElementsWithMinHeap(5);
        Integer dataArr[] = {15, 17, 12, 18, 14};

        heap.add(dataArr);

        // Let's print original Heap
        System.out.println(heap);

        heap.add(new Integer[]{16});

        System.out.println(heap);

        heap.add(new Integer[]{19});
        System.out.println(heap);

        heap.add(new Integer[]{21, 9, 29});
        System.out.println(heap);


    }


}
