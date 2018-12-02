package com.dsgnptrn.creational.factory.improved;

public class BikeFactory extends TransportFactory {

	@Override
	Transport create() {
		
		return new Bike();
	
	}
	
	

}
