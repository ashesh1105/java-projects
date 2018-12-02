package com.algorithms.graphs.shortestpath.dijkstra;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vertex implements Comparable<Vertex> {
	
	private String name;
	private List<Edge> adjacenciesList;
	private boolean visited;
	private Vertex predecessor;
	private double distance = Double.MAX_VALUE;	// Distance from starting Vertex
	
	public Vertex(String name) {
		this.name = name;
		this.adjacenciesList = new ArrayList<>();
	}
	
	public void addNeighbor(Edge e) {
		this.adjacenciesList.add(e);
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public int compareTo(Vertex otherVertex) {
		return Double.compare(this.getDistance(), otherVertex.getDistance());
	}
	
	

}
