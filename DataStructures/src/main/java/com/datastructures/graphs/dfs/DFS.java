package com.datastructures.graphs.dfs;

import java.util.Stack;
import lombok.Getter;
import com.datastructures.graphs.bfs.Vertex;

/**
 * DFS explores as far as possible along each branch before backtracking.
 * Memory Complexity is better than BFS. Memory complexity of DFS comes as O(logN) since we save number
 * of nodes equal to height of the tree and for a balanced tree, height is log(N), N being number of nodes in tree.
 * DFS is good for:
 * a) Topology Ordering
 * b) Kosaraju algorithm for Recommendation Engine - helps find strongly connected components in a graph.
 * c) Detecting Cycles - checking whether a graph is a DAG (Directed Acyclic Graph) or not. A graph with no directed cycles.
 * d) Generating Mazes or finding way out of a maze
 */

public class DFS {

	@Getter
	private Vertex root;
	private Stack<Vertex> stack;
	
	public DFS(int data) {
		root = new Vertex(data);
		stack = new Stack<>();
	}
	
	public void process() {
		root.setVisited(true);
		stack.push(root);
		
		while (!stack.isEmpty()) {
			Vertex actualVertex = stack.pop();
			System.out.println(actualVertex);
			actualVertex.getNeighborList().forEach(elem -> stack.push(elem));
		}
		
	}
}
