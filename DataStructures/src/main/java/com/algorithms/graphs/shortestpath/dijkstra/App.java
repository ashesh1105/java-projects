package com.algorithms.graphs.shortestpath.dijkstra;

public class App {

	public static void main(String[] args) {
		
		Vertex v0 = new Vertex("A");
		Vertex v1 = new Vertex("B");
		Vertex v2 = new Vertex("C");
		
		v0.addNeighbor(new Edge(1, v0, v1));
		v0.addNeighbor(new Edge(3, v0, v2));
		v1.addNeighbor(new Edge(1, v1, v2));
		
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();
		dijkstra.computePaths(v0);
		System.out.println(dijkstra.getShortedPathTo(v2));
	}

}
