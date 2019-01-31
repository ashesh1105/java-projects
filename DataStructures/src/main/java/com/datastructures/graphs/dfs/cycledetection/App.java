package com.datastructures.graphs.dfs.cycledetection;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {

		CycleDetection cycleDetection = new CycleDetection();
		List<Vertex> vertices = new ArrayList<>();

		Vertex vertex1 = new Vertex("1");
		Vertex vertex2 = new Vertex("2");
		Vertex vertex3 = new Vertex("3");
		Vertex vertex4 = new Vertex("4");
		Vertex vertex5 = new Vertex("5");
		Vertex vertex6 = new Vertex("6");
		
		vertex1.addNeighbor(vertex2);
		vertex2.addNeighbor(vertex3);
		vertex3.addNeighbor(vertex1);
		vertex4.addNeighbor(vertex1);
		// Below is where the cycle will be
		vertex4.addNeighbor(vertex5);
		vertex5.addNeighbor(vertex6);
		vertex6.addNeighbor(vertex4);
		
		vertices.add(vertex1);
		vertices.add(vertex2);
		vertices.add(vertex3);
		vertices.add(vertex4);
		vertices.add(vertex5);
		vertices.add(vertex6);
		
		cycleDetection.detectCycle(vertices);

	}

}
