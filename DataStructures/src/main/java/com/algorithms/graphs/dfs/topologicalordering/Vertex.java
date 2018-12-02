package com.algorithms.graphs.dfs.topologicalordering;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString(of={"data"})
public class Vertex {
	
	private String data;
	@Setter
	private boolean visited;
	private List<Vertex> neighborList;
	
	public Vertex(String data) {
		this.data = data;
		this.neighborList = new ArrayList<>();
	}
	
	public void addNeighbor(Vertex vertex) {
		this.neighborList.add(vertex);
	}

}
