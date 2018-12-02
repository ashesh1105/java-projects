package com.algorithms.graphs.bfs;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString(of={"data"})
public class Vertex {
	
	private int data;
	@Setter
	private boolean visited;
	@Setter
	private List<Vertex> neighborList;
	
	public Vertex(int data) {
		this.data = data;
		neighborList = new ArrayList<>();
	}
}
