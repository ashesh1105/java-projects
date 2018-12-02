package com.dsgnptrn.creational.abstractfactory.improved;

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

	public static void initializeGui(WidgetFactory factory) {

		initializeGui(factory.createScrollBar(), factory.createWindow());

	}

	public static void initializeGui(ScrollBar bar, Window window) {

		System.out.println("Do initialize logic here with " + bar.getClass().getName() + " and "
				+ window.getClass().getName());

	}

	public static void main(String[] args) {

		WidgetFactory factory = new YellowThemeWidgetFactory();
		initializeGui(factory);

		factory = new PinkThemeWidgetFactory();
		initializeGui(factory);

		/*
		 * So with above, we have centralized the creating logic in our factories and there is no chance of mixing
		 * between product families anymore, i.e., a Pink Theme ScrollBar will never appear with Yellow Theme Window. We
		 * as a programmer don't need to worry about objects that belong together once a factory is created like
		 * YellowThemeWidgetFactory! As System Designer we will be very sure that Objects that belong together will be
		 * created accordingly.
		 */

	}

}
