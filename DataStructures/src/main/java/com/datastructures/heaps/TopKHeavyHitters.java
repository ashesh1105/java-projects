package com.datastructures.heaps;

import lombok.Getter;

import java.util.*;

/**
 This class is similar to TopKElementsWithCustomMinHeap except here, we are using the built-in Java PriorityQueue
 instead of our custom implementation.

 Another key difference between this class and TopKElementsWithCustomMinHeap is, this class does not remember the events
 sent during subsequent calls, it is more for Fast Path of TopK Problem where you collect an array of events for a duration
 of time, say 1 min, use this class to get TopK and send that to Storage as TopK for that duration or time interval or
 subsequent aggregations, like if 5 minutes data is needed, 5 of those 1 minute TopK Results can be combined to get
 an approximate TopK for 5 minutes.

 Class TopKElementsWithCustomMinHeap on other hand, can be called again and again and the map associated with it keeps
 data accumulated and similarly the TopK results from it, the heap data show the TopK at any point all the way since
 first call to the last one. It is also important to note that with this class, even with subsequent calls, heap never
 keeps any duplicate events. So we can say, it is more for Batch Processing.
 TopKElementsWithCustomMinHeap: 

 With above said, we might need a less memory intensive Data Structure like Count-min Sketch instead of a HashMap.
 Refer the TopK Design Considerations for more details on it:
 https://docs.google.com/document/d/1UvNcCOBehnWuv7Ys_L1NVu4AzqVdddaR4BgHU7m5vvo/edit

 */

class HeavyHitter {

    @Getter
    private final String identifier;
    @Getter
    private final int frequency;

    HeavyHitter(String identifier, int frequency) {
        this.identifier = identifier;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "identifier='" + identifier + '\'' +
                ", frequency=" + frequency;
    }
}

public class TopKHeavyHitters {

    public List<HeavyHitter> topK(String[] events, int k) {

        Map<String, Integer> frequencyTable = new HashMap<>();
        PriorityQueue<HeavyHitter> heap = new PriorityQueue<>(Comparator.comparing(e -> e.getFrequency()));

        // Add the incoming array of events to Map
        for (String event : events) {
            // Notice the use of Map.getOrDefault(Object key, Integer default) here!
            frequencyTable.put(event, frequencyTable.getOrDefault(event, 0) + 1);
        }

        // Iterate through map and add the events with frequency to heap
        frequencyTable.forEach((event, frequency) -> {
            heap.offer(new HeavyHitter(event, frequency));
        });

        if (heap.size() > k) heap.poll();

        return new ArrayList<HeavyHitter>(heap);
    }

    public static void main(String[] args) {

        // We are passing 4 As, 3 Bs, 3 Cs, 1 D and 1 E
        String dataArr[] = {"A", "C", "B", "C", "A", "E", "M", "A", "B", "C", "A", "D", "B", "L", "M", "L"};

        List<HeavyHitter> topK = new TopKHeavyHitters().topK(dataArr, 5);

        System.out.println("TopK Heavy Hitters in this run: " + Arrays.deepToString(topK.toArray()));

    }
}
