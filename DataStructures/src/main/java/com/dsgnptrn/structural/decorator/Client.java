package com.dsgnptrn.structural.decorator;

public class Client {

	/*
	 * Decorator Pattern is intended to attach additional responsibilities to an object dynamically. Decorators provide a flexible
	 * alternative to subclassing for extending functionality. Also known as "Wrapper". Adapter Patterns also known as "Wrapper" but they
	 * provide access to legacy systems, so the intentions of two patterns are different.
	 * 
	 * Usages: 1) Add functionality to an object without affecting other objects, 2) Functionalities can be taken away in future, hence
	 * they're flexible and don't affect other objects, 3) Extension by subclassing is difficult (due to code duplication).
	 * 
	 * Structure: Base Component -> Regular Implementation (We don't change this) and Decorator (Interface) -> Implementations of Decorator.
	 * So clients can opt to use the Decorator implementations instead of Regular Implementation of Component. If we remove the decorator
	 * tomorrow, it won't affect other regular objects.
	 * 
	 * Drawbacks: 1) Object identity can not be used with Decorators, e.g., Databases where components have an ID, don't use decorators
	 * there, 2) Its possible to result into too many small Decorators leading to performance problems, so think carefully before coming up
	 * with new decorator.
	 */

	public static void main(String[] args) {

		IconWindow iconWindow = new IconWindow();
		iconWindow.draw();

		ScrollBarWindow scrollBarWindow = new ScrollBarWindow();
		scrollBarWindow.draw();

		/*
		 * What if we need an IconScrollBarWindow where we need to draw an icon, a scrollbar and the window (only once, unlike above example
		 * where window is drawn each time draw() method is called on implementations like IconWindow, ScrollBarWindow, etc., as
		 * Window.draw() method is explicitly called there as superclass methods. This is an ideal case where we need Decorator Pattern. See
		 * "improved" package for this!
		 */
		
		// Inefficient implementation with no decorator pattern
		System.out.println("IconScrollBarWindow implementation with no decorator pattern:");
		IconScrollBarWindow iconScrollBarWindow = new IconScrollBarWindow();
		iconScrollBarWindow.draw();

	}

}
