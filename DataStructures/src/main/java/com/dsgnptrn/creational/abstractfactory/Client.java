package com.dsgnptrn.creational.abstractfactory;

public class Client {

	/*
	 * AbstractFactory is intended to provide an interface for creating families of related or dependent objects without
	 * specifying their concrete classes. In the industry it is also know as "Kit"
	 * 
	 * Usage: 1) Creating of products independent of application, 2) Configuration of product families are required, 3)
	 * Hide product implementation and only provide interface.
	 * 
	 * *** Examples from Java Libraries:
	 * https://stackoverflow.com/questions/1673841/examples-of-gof-design-patterns-in-javas-core-libraries/2707195
	 */

	public static void initializeGui(ScrollBar bar, Window window) {

		System.out.println("Do initialize logic here with "
				+ bar.getClass().getName() + " and "
				+ window.getClass().getName());

	}

	public static void main(String[] args) {

		ScrollBar bar = new YellowThemeScrollBar();
		Window window = new YellowThemeWindow();
		initializeGui(bar, window);

		/*
		 * Do you see the problem in above? As programmer you'll have to remember the product family every time like
		 * which Window goes with which scrollbar implementation. What if you do the mistake as below?
		 */

		bar = new YellowThemeScrollBar();
		window = new PinkThemeWindow();	// Programmer did a mistake here!
		System.out.println("\nProgrammer did a mistake here:");
		initializeGui(bar, window);

		// You'll have weird results from above where we'll have Yellow Theme Scrollbar on a Pink Theme Window!
		// AbstractFactory Patterns solves this. See the pattern in "improved" package.

	}

}
