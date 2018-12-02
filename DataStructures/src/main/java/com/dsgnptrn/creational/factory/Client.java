package com.dsgnptrn.creational.factory;

public class Client {

	public static void main(String[] args) {

		Transport vehicle = new Transport();
		System.out.println(vehicle.drive());

		// For car, we have to write same code as above:
		Transport anotherVehicle = new Car();
		System.out.println(anotherVehicle.drive());

		/*
		 * The problem here is, we don't know in advance on which kind of
		 * vehicle we need. What if there is a Truck as well and we realize that
		 * later? What if a new implementation is added later on by someone? Do
		 * we need to then change the client so much? So we really need to build
		 * an extensible framework. Check improved package for Factory Pattern and how it will help!
		 */

	}

}
