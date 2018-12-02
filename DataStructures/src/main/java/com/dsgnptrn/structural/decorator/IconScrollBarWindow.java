package com.dsgnptrn.structural.decorator;

public class IconScrollBarWindow extends Window {
	
	@Override
	public void draw() {
		System.out.println("Drawing an icon");
		System.out.println("Drawing a scrollbar");
		super.draw();
	}

}
