package com.datastructures.heaps;

import java.util.*;

/**
 * A common situation comes during many use cases to maintain the top K elements at anytime. Examples can be:
 * - Top K items sold on an eCommerce Website
 * - Tok K liked or viewed videos on a Video Sharing app like YouTube
 * - Top K clicked keywords on Advertisement / Recommendations Engine app
 * - Top K clicked Search Results on a Search Engine / AutoSearch / Type ahead app, etc.
 * <p>
 * Given Billions of Requests per unit of time, how we we maintain such a list handy at anytime?
 * Above is more of a System Design Problem but that bigger problem will need a low level implementation of an
 * algorithm that can give us Top K Objects at anytime locally on a Server, right? This is demonstrated below.
 * <p>
 * We will achieve the objectives of this algorithm by designing a Min Heap of size K. Anytime there's an add request
 * and size is full, we will:
 * A) peak the Min Heap to get minimum element from the Heap.
 * B) Check if new element is more than min element in the Heap, if not, then ignore the add request.
 * C) poll the Min Heap, meaning remove the minimum element from it and then add the new element.
 * D) Code an API to return top K elements anytime, which will be the underlying data itself, array in our case
 * This API can be a simple getData() which will return all of heap data anytime which will be Top K elements so far
 *
 * Above is high level approach. In practice, we will have to deal with these complexities as well:
 * E) We need a map to maintain identifier to its frequency. In our case, we create a class called Event with
 *    id and frequency. In map we can use id as key and the Event object itself as value.
 * F) We need to add Event object to Heap object and use Comparable interface with Event to compare the objects in heap.
 * G) An incoming event might get into following situation:
 *      1) Map does not has it - here, we add the event to Map and Heap, both.
 *      2) Map has it but heap does not, here, we check if this event has (now) higher frequency than min element in heap,
 *          if so, add this new event to Heap.
 *      3) Map has it and heap as well has it - here, we do not want to add duplicate event in Heap! So, we:
 *          i) Increment its frequency by pulling the object from the Map itself and
 *          ii) Check if now this element is the min heap element, do the fixDown with index as 0.
 *
 * There's just one piece of the puzzle left. On G.2 and G.3 above, how will you know if heap has the new element?
 * H) We use one more Data Structure - Set, if it has it, heap has it, else not. Every time we add an element to heap,
 *    we also add that to Set and every time we have to poll an element from heap, we remove that element from Set as well.
 *
 */

// Let's define a class which will hold event identifier and its frequency
class Event implements Comparable {

    private String id;
    private int frequency;

    public Event(String id, int frequency) {
        this.id = id;
        this.frequency = frequency;
    }

    public int getFrequency() {
        return this.frequency;
    }

    void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Object o) {

        if (!(o instanceof Event)) {
            throw new RuntimeException("Can't compare objects other than Event type!");
        }
        Event e = (Event)o;
        if (this.frequency > e.getFrequency()) {
            return 1;
        } else if (this.frequency < e.getFrequency()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id.equals(event.id);
    }

    @Override
    public String toString() {
        return id + " -> " + frequency;
    }
}

public class TopKElementsWithCustomMinHeap {

    private Event[] heapData;
    private int capacity;
    private int currentPosition = -1;
    private Map<String, Event> map; // contains frequency of all the events, heap or off-heap :)
    private Set<Event> set; // helps keep unique events in Heap

    public TopKElementsWithCustomMinHeap(int capacity) {
        this.capacity = capacity;
        heapData = new Event[capacity];
        map = new HashMap<>();
        set = new HashSet<>();
    }


    public Event peak() {
        return heapData[0];
    }

    public int size() {
        return currentPosition;
    }

    // This API can be called anytime to get Top K Elements, where K=capacity of this heap we initialize it with
    // Note: returning array will confirm to Min Heap data structure, will not be sorted.
    // It can be sorted by using Arrays.sort method, first element will still be the same, i.e., min of the top K elements
    public Event[] getTopKEvents() {
        return heapData;
    }

    public void add(String[] data) {

        for (String elem : data) {

            // Increment the frequency of this Event, if map has it, else add it
            if (map.containsKey(elem)) {
                Event e = map.get(elem);
                int v = e.getFrequency();
                e.setFrequency(v+1);

                // If heap does not has it, add it, else:
                // 1) increment the frequency and 2) fixDown if this event was the minimum element in heap
                if (!set.contains(map.get(elem))) {
                    // Below method also adds the new event to set, if it gets added to heap
                    addToHeap(elem);
                } else {
                    // If we altered the frequency of min event of the heap, we need to fix down
                    if (e.equals(heapData[0])) fixDown(0);
                }
            } else {
                map.put(elem, new Event(elem, 1));
                addToHeap(elem);
            }
        }
    }

    private void addToHeap(String elem) {
        // If capacity is full, remove the existing minimum only if new one has higher frequency
        if (currentPosition >= capacity - 1) {

            if (map.get(elem).compareTo(heapData[0]) > 0) {
                Event polledData = poll();
                set.remove(polledData);
//                    System.out.println("\nRemoving " + polledData + " from the heap and adding event with id: " + elem);
            } else {
                return;
            }
        }

        heapData[++currentPosition] = map.get(elem);
        fixUp(currentPosition);
        set.add(map.get(elem));
    }

    // Note here, a child can have only one parent, so fixUp is straight forward
    private void fixUp(int index) {

        int parentIndex = (index - 1) / 2;

        while (parentIndex >= 0 && heapData[index].compareTo(heapData[parentIndex]) < 0) {
            Event temp = heapData[parentIndex];
            heapData[parentIndex] = heapData[index];
            heapData[index] = temp;
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    public Event poll() {

        Event polledData = heapData[0];

        heapData[0] = heapData[currentPosition--];
        heapData[currentPosition + 1] = null;
        fixDown(0);

        return polledData;
    }

    // Fixing Down goes a bit complex since parent can be compared and swapped only with the smaller child!
    private void fixDown(int index) {

        int upto = currentPosition;

        while (index < upto) {

            int childIndexToSwap;
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;

            if (leftChildIndex <= upto) {

                if (rightChildIndex > upto) {
                    childIndexToSwap = leftChildIndex;
                } else {
                    childIndexToSwap = (heapData[leftChildIndex].compareTo(heapData[rightChildIndex]) < 0 ? leftChildIndex : rightChildIndex);
                }

                if (heapData[index].compareTo(heapData[childIndexToSwap]) > 0) {
                    Event temp = heapData[index];
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

        TopKElementsWithCustomMinHeap heap = new TopKElementsWithCustomMinHeap(5);
        // We are passing 4 As, 3 Bs, 3 Cs, 1 D and 1 E
        String dataArr[] = {"A", "C", "B", "C", "A", "E", "M", "A", "B", "C", "A", "D", "B", "L", "M", "L"};

        heap.add(dataArr);

        // Let's print original Heap
        System.out.println("Original Heap: " + heap);

        heap.add(new String[]{"F"});

        System.out.println("Last Heap + F: " + heap);

        heap.add(new String[]{"F"});
        System.out.println("Last Heap + F: " + heap);

        heap.add(new String[]{"C", "A", "E"});
        System.out.println("Last Heap + {\"C\", \"A\", \"E\"}: "+ heap);

        heap.add(new String[]{"G", "G", "G"});
        System.out.println("Last Heap + {\"G\", \"G\", \"G\"}: " + heap);

        heap.add(new String[]{"E", "E", "K", "K", "K", "K"});
        System.out.println("Last Heap + {\"E\", \"E\", \"K\", \"K\", \"K\", \"K\"}: " + heap);

    }


}
