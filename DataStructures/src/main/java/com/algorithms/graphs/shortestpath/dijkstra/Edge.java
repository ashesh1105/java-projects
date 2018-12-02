package com.algorithms.graphs.shortestpath.dijkstra;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Edge {
	
	private double weight;
	private Vertex startVertex;
	private Vertex targetVertex;
	
	public Edge(double weight, Vertex startVertex, Vertex targetVertex) {
		this.weight = weight;
		this.startVertex = startVertex;
		this.targetVertex = targetVertex;
	}

}
