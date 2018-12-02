package com.dsgnptrn.structural.decorator.improved;

public class IconWindowDecorator extends Window {
	
	private Window window;

	public IconWindowDecorator(Window window) {
		this.window = window;
	}
	
	@Override
	public void draw() {
		System.out.println("Drawing an icon");
		window.draw();
	}

}
