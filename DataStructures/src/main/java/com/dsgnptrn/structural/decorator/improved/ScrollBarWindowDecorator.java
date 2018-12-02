package com.dsgnptrn.structural.decorator.improved;

import com.dsgnptrn.structural.decorator.improved.Window;

public class ScrollBarWindowDecorator extends Window {
	
	private Window window;
	
	public ScrollBarWindowDecorator(Window window) {
		this.window = window;
	}
	
	@Override
	public void draw() {
		System.out.println("Drawing a scrollbar");
		window.draw();
	}

}
