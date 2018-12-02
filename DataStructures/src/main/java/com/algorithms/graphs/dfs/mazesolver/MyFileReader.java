package com.algorithms.graphs.dfs.mazesolver;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class MyFileReader {

	private int[][] map;
	private String fileName;
	private int numOfRows;
	private int numOfColumns;
	private int startPositionCol; // the start index of the element 2 "start point"  colIndex
	private int startPositionRow; // start index of the element 2 "start point" rowIndex
	
	public MyFileReader(String fileName, int numOfRows, int numOfColumns){
		this.fileName = fileName;
		this.numOfColumns = numOfColumns;
		this.numOfRows = numOfRows;
		this.map = new int[numOfRows][numOfColumns];
	}
	
	public void parseFile(){
		
		try{
			
			Scanner scanner = new Scanner(new File(this.fileName));
			
			for(int i=0;i<this.numOfRows;i++){
				for(int j=0;j<this.numOfColumns;j++){
					
					map[i][j] = scanner.nextInt();	 // read the integers from the file
					
					if( map[i][j] == 2 ){   // we have found the 2 so save the col and row indexes !!!
						startPositionCol = j;
						startPositionRow = i;
					}
				}
			}
			
			scanner.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public int getStartPositionCol() {
		return startPositionCol;
	}

	public int getStartPositionRow() {
		return startPositionRow;
	}

	public int[][] getMap(){
		return this.map;
	}
}
