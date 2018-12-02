package com.algorithms.graphs.dfs.mazesolver;

import java.net.URL;

public class App {

	public static void main(String[] args) {
		
		URL url = App.class.getClassLoader().getResource("map_mazesolver.txt");
		String fileName = url.getPath();

		MyFileReader fileReader = new MyFileReader(fileName, 7, 7);
		fileReader.parseFile();
		MazeSolver mazeSolver = new MazeSolver(fileReader.getMap(),
				fileReader.getStartPositionRow(),
				fileReader.getStartPositionCol());
		mazeSolver.findWayOut();

	}
}
