package com.algorithms.graphs.shortestpath.dag;

import java.util.ArrayList;
import java.util.List;

import com.algorithms.graphs.shortestpath.dag.Edge;
import com.algorithms.graphs.shortestpath.dag.Vertex;

public class App {
	
	public static void main(String[] args) {
		
		Vertex v0 = new Vertex("A");
		Vertex v1 = new Vertex("B");
		Vertex v2 = new Vertex("C");
		
		List<Vertex> vertices = new ArrayList<>();
		vertices.add(v0);
		vertices.add(v1);
		vertices.add(v2);
		
		v0.addNeighbor(new Edge(1, v0, v1));
		v0.addNeighbor(new Edge(3, v0, v2));
		v1.addNeighbor(new Edge(1, v1, v2));
		
		AcyclicShortestPath acyclicShortestPath = new AcyclicShortestPath();
		acyclicShortestPath.shortestPath(vertices, v0, v2);
		acyclicShortestPath.showShortestPathTo(v2);
		
//		Vertex vertex0 = new Vertex("r");
//		Vertex vertex1 = new Vertex("t");
//		Vertex vertex2 = new Vertex("x");
//		Vertex vertex3 = new Vertex("s");
//		Vertex vertex4 = new Vertex("y");
//		Vertex vertex5 = new Vertex("z");
//		
//		List<Vertex> vertexList = new ArrayList<>();
//		vertexList.add(vertex0);
//		vertexList.add(vertex1);
//		vertexList.add(vertex2);
//		vertexList.add(vertex3);
//		vertexList.add(vertex4);
//		vertexList.add(vertex5);
//		
//		vertex0.addNeighbour(new Edge(3, vertex0, vertex1));
//		vertex0.addNeighbour(new Edge(5, vertex0, vertex3));
//		
//		vertex1.addNeighbour(new Edge(7, vertex1, vertex2));
//		vertex1.addNeighbour(new Edge(4, vertex1, vertex4));
//		vertex1.addNeighbour(new Edge(2, vertex1, vertex5));
//		
//		vertex2.addNeighbour(new Edge(-1, vertex2, vertex4));
//		vertex2.addNeighbour(new Edge(1, vertex2, vertex5));
//		
//		vertex3.addNeighbour(new Edge(6, vertex3, vertex2));
//		
//		vertex4.addNeighbour(new Edge(-2, vertex4, vertex5));
//		
//		AcyclicShortestPath acyclicShortestPath = new AcyclicShortestPath();
//		acyclicShortestPath.shortestPath(vertexList, vertex3, vertex0);
//		acyclicShortestPath.showShortestPathTo(vertex5);

	}
}
