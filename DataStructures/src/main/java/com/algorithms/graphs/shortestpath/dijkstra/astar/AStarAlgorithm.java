package com.algorithms.graphs.shortestpath.dijkstra.astar;

public class AStarAlgorithm {
	
	/**
	 * A* algorithm is a variation of Dijkstra algorithm and is very useful to compute shortest paths for maps.
	 * What we do here is, apart from distance, we add one heuristic with Vertex, which indicates how far is
	 * the actual target we need to go to. So PriorityQueue sorts the Vertices based on Distance + heuristic and hence
	 * helps compute the shortest path needed to get to target much faster.
	 * 
	 * Dijkstra otherise will keep on comuting the shortest path for all vertex from source in a greedy way. It just isn't
	 * focussed on computing the shortest path we need to our specific target and A* helps on exactly that.
	 * 
	 * To be implemented later
	 */

}
