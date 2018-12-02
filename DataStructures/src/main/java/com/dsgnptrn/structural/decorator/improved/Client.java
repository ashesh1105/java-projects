package com.dsgnptrn.structural.decorator.improved;

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
	 * 
	 * *** Examples from Java Libraries: java.io: InputStream, OutputStream, Reader, Writer, java.util: Collections, synchronizedMap, etc.
	 * https://stackoverflow.com/questions/1673841/examples-of-gof-design-patterns-in-javas-core-libraries/2707195
	 */

	public static void main(String[] args) {

		Window window = new Window();
		IconWindowDecorator iconWindowDecorator = new IconWindowDecorator(window);
		ScrollBarWindowDecorator scrollBarWindowDecorator = new ScrollBarWindowDecorator(iconWindowDecorator);

		scrollBarWindowDecorator.draw();

		/*
		 * Window object above is being decorated by Icon and the result object is again being decorated by ScrollBar. This is decorator
		 * chaining. Imagine 5 more UI Elements like Button, TextBox, etc., can also be added to this chain where once all the elements are
		 * drawn, window will be drawn. This is decorator pattern where we do not need to know too much about all the possible objects and
		 * their functionality and we can chain their decorators.
		 */

	}

}
