package com.algorithms.graphs.dfs.topologicalordering;

import java.util.Stack;

import lombok.Getter;

public class TopologicalOrdering {
	
	@Getter
	private Stack<Vertex> stack;
	
	public TopologicalOrdering() {
		this.stack = new Stack<>();
	}
	
	public void dfs(Vertex vertex) {
		vertex.setVisited(true);
		for (Vertex v : vertex.getNeighborList()) {
			if (!v.isVisited()) {
				dfs(v);
			}
		}
		stack.push(vertex);
	}
}
