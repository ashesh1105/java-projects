package com.algorithms.graphs.dfs.cycledetection;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Vertex {
	
	private String name;
	@Setter
	private boolean visited;
	@Setter
	private boolean beingVisited;
	private List<Vertex> adjacenciesList;
	
	public Vertex(String name) {
		this.name = name;
		adjacenciesList = new ArrayList<>();
	}
	
	public void addNeighbor(Vertex v) {
		this.adjacenciesList.add(v);
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
