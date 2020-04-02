package com.datastructures.graphs.shortestpath.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
	
	/**
	 * Time complexity of Dijkstra's Algorithm is O(E+V+logV), where E are # of edges V are number of Vertices (nodes)
	 * in a given graph
	 * 
	 * Dijkstra's Algorithm can not handle negative edge weight. DAG (Directed Acyclic Graph) Algorithm or Bellman-Ford
	 * algorithm can do that. DAG can not handle if there are cycles in the graph. Bellman-Ford algorithm, although very
	 * robust, but is slower compared to Dijkstra's which with time complexity of O(E*V) (check this!) For Directed 
	 * graphs with no cycles
	 * (if we are sure, we can check however rather quickly), DAG is the fastest with Time Complexity as O(E+V), linear
	 * time complexity.
	 */

	public void computePaths(Vertex sourceVertex) {

		sourceVertex.setDistance(0);
		// So we can get Vertex with minimum distance each time and process it
		
		PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(sourceVertex);

		while (!priorityQueue.isEmpty()) {

			// Below gives vertex which are still in queue and with minimum distance
			Vertex actualVertex = priorityQueue.poll();

			for (Edge e : actualVertex.getAdjacenciesList()) {
				Vertex v = e.getTargetVertex();
				double newDistance = actualVertex.getDistance() + e.getWeight();
				
				if (newDistance < v.getDistance()) {
					
					// Remove the target vertex from PriorityQueue, update it,
					// and add to queue again
					// Remove it if vertex v is in the queue
					priorityQueue.remove(v);
					
					// This will help get shortest distance from Source
					v.setDistance(newDistance);
					
					// This will help get actual path to this Vertex starting
					// from Source
					v.setPredecessor(actualVertex);
					
					// Finally, add this vertex to queue
					priorityQueue.add(v);
				}
			}
		}
	}
	
	public List<Vertex> getShortedPathTo(Vertex vertex) {
		
		List<Vertex> shortestPathToTarget = new ArrayList<>();
		
		for (Vertex v = vertex; v != null; v = v.getPredecessor()) {
			shortestPathToTarget.add(v);
		}
		
		// Reverse the order of vertices
		Collections.reverse(shortestPathToTarget);
		
		return shortestPathToTarget;
	}

}
