package com.datastructures.queue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class DancingOrder {

	public static void main(String[] args) {
		// Declare a priority queue
		Queue<String> men = new PriorityQueue<String>(Comparator.reverseOrder());  // if reverse lexicographical order needed
		Queue<String> women = new PriorityQueue<String>();	// Can pass Comparator.naturalOrder(), will be same result
		String sex = "";
		String line = null;
		URL url = DancingOrder.class.getClassLoader().getResource("Dancers.txt");
		String file = url.getPath();
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
			// Read line and populate both the Priority Queues
			while ((line = reader.readLine()) != null) {
				sex = line.substring(0, 1);
				if (sex.equalsIgnoreCase("M")) {
					men.add(line.substring(1));
				}
				if (sex.equalsIgnoreCase("F")) {
					women.add(line.substring(1));
				}
				line = null;
			}
			// Print the Dancing Pairs
			System.out.println("Dancing pair will be:\n");
			while (men.size() != 0 && women.size() != 0) {
				System.out.println(men.poll().trim() + " and " + women.poll().trim());
			}
			// Check for men or women still waiting and print the next one in
			// the line
			if (men.size() == 0 && women.size() != 0) {
				System.out
						.println("There are one or more women available to be paired up");
				System.out.println("Next women waiting to be paired up is: "
						+ women.peek());
			}
			if (women.size() == 0 && men.size() != 0) {
				System.out
						.println("There are one or more men available to be paired up");
				System.out.println("Next men waiting to be paired up is: "
						+ men.peek());
			}

		} catch (IOException e) {
			System.out.println("Error openinig file.");
		}
	}
}
