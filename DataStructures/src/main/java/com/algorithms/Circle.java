package main.java.com.algorithms;

public class Circle implements Comparable<Circle> {
	
	private int radius;

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Circle(int radius) {
		this.radius = radius;
	}

	@Override
	public int compareTo(Circle circle) {
		if (!(circle instanceof Circle)) {
			// log error
		}
		int radius = circle.getRadius(); 
		if (this.radius == radius) {
			return 0;
		}
		if (this.radius > radius) {
			return 1;
		}
		else {
			return -1;
		} 
	}

}
