package com.algorithms.graphs.bfs;

public class App {

	public static void main(String[] args) {
		
		BFS bfs = new BFS(5);
		
		// Set data for bfs
		Vertex vertex10 = new Vertex(10);
		vertex10.getNeighborList().add(new Vertex(14));
		vertex10.getNeighborList().add(new Vertex(8));
		bfs.getRoot().getNeighborList().add(vertex10);
		
		Vertex vertex15 = new Vertex(15);
		vertex15.getNeighborList().add(new Vertex(45));
		vertex15.getNeighborList().add(new Vertex(69));
		vertex15.getNeighborList().add(new Vertex(70));
		bfs.getRoot().getNeighborList().add(vertex15);
		
		Vertex vertex20 = new Vertex(20);
		vertex20.getNeighborList().add(new Vertex(22));
		vertex20.getNeighborList().add(new Vertex(38));
		bfs.getRoot().getNeighborList().add(vertex20);
		
		Vertex vertex7 = new Vertex(7);
		vertex7.getNeighborList().add(new Vertex(11));
		vertex7.getNeighborList().add(new Vertex(15));
		vertex7.getNeighborList().add(new Vertex(108));
		bfs.getRoot().getNeighborList().add(vertex7);
		
		Vertex vertex19 = new Vertex(19);
		vertex19.getNeighborList().add(new Vertex(2));
		vertex19.getNeighborList().add(new Vertex(32));
		bfs.getRoot().getNeighborList().add(vertex19);

		// call bsf.process to print all the vertex
		bfs.process();
	}

}
