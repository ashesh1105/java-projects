package com.dsgnptrn.creational.factory.improved;

public class Client {
	
	/**
	 * Example from Java Libraries:
	 * https://stackoverflow.com/questions/1673841/examples-of-gof-design-patterns-in-javas-core-libraries/2707195
	 */

	public static void main(String[] args) {

		TransportFactory factory = new BikeFactory();

		// For Bike
		Transport vehicle1 = factory.create();
		System.out.println(vehicle1.drive());

		// For Car
		factory = new CarFactory();
		Transport vehicle2 = factory.create();
		System.out.println(vehicle2.drive());

		/*
		 * This way it will be much easier to add a new vehicle to the system.
		 * We can write our code in a generic way that only works with
		 * TransportFactory and in runtime environment we can change the factory
		 * implementation.
		 */

	}

}
