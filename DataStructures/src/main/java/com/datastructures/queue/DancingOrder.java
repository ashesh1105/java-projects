package com.datastructures.queue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.PriorityQueue;
import java.util.Queue;

public class DancingOrder {

	public static void main(String[] args) {
		// Declare a priority queue
		Queue<String> men = new PriorityQueue<String>();
		Queue<String> women = new PriorityQueue<String>();
		String sex = "";
		String line = null;
		BufferedReader reader;
		URL url = DancingOrder.class.getClassLoader().getResource("Dancers.txt");
		String file = url.getPath();
		try {
			// Read line and populate both the Priority Queues
			reader = new BufferedReader(new FileReader(file));
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
				System.out.println(men.poll().trim() + " and " + women.poll());
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
