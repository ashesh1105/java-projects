package com.algorithms.graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

import lombok.Getter;
/**
 * In BFS, we visit a vertex (root) and then all its neighbors or children and so on.
 * Time Complexity of BFS is similar to DFS but memory complexity is higher O(n) considering that we
 * have to store all the nodes in a level in queue to process then. Number of leaf nodes in a balanced tree
 * is ceil(N/2), N being number of nodes, so memory complexity of BFS is O(n).
 * since we need to store neighbor nodes reference in order to get to them later from queue
 * BFS is good for:
 * a) Dijkstra algorithm - to compute shortest path
 * b) AIs / Machine Learning, since for a robot, immediate surrounding will matter more than the ones far off
 * c) Computing maximum flow: Edmond-Karp algorithm
 * d) Cheyen's algorithm in Garbage Collection - helps maintain active references to heap memory
 * e) Serialization / Deserialization of a Tree like structure, when order matter, allows the tree to be reconstructed.
 *
 */
public class BFS {
	
	@Getter
	private Vertex root;
	private Queue<Vertex> queue;
	
	public BFS(int data) {
		root = new Vertex(data);
		queue = new LinkedList<>();
	}
	
	public void process() {
		root.setVisited(true);
		queue.add(root);
		
		while (!queue.isEmpty()) {
			Vertex actualVertex = queue.remove();
			if (!actualVertex.isVisited()) {
				System.out.println(actualVertex);
				actualVertex.setVisited(true);
				actualVertex.getNeighborList().forEach(elem -> {
					if (!elem.isVisited()) {
						elem.setVisited(true);
						queue.add(elem);
					}
				});
			}
		}
		
	}
}
