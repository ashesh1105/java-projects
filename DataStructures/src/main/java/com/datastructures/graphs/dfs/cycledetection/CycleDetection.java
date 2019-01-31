package com.datastructures.graphs.dfs.cycledetection;

import java.util.List;

public class CycleDetection {
	
	public void detectCycle(List<Vertex> vertices) {
		vertices.forEach(vertex -> {
			if (!vertex.isVisited()) {
				dfs(vertex);
			}
		});
	}

	private void dfs(Vertex vertex) {
		
		System.out.println("DFS on vertex: " + vertex + " setting beingVisited to true and visiting its neighbors...");
		vertex.setBeingVisited(true);
		
		for (Vertex v : vertex.getAdjacenciesList()) {
			
			System.out.println("Visiting the neighbors of vertex: " + v);
			
			if (v.isBeingVisited()) {
				System.out.println("\n"+ "There is a backward edge at vertex " + v + ": so there is a cycle!!!" + "\n");
			}
			
			if (!v.isVisited()) {
				System.out.println("Visiting vertex " + v + " recursively...");
				v.setVisited(true);
				dfs(v);
			} else {
				System.out.println("Vertex " + v + " was already visited." );
			}
		}
		System.out.println("\n" + "Done with " + vertex + " set beingVisited(false) + visited(true)..." + "\n");
		vertex.setBeingVisited(false);
		vertex.setVisited(true);
		
	}

}
