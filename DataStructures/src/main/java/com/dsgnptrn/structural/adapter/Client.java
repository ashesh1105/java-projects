package com.dsgnptrn.structural.adapter;

public class Client {

	/*
	 * Adapter Pattern:
	 * 
	 * Intended to convert the interface of a class into another interface the clients expect. Adapter lets classes work together that
	 * couldn't otherwise because of incompatible interfaces. Also known as "Wrapper".
	 * 
	 * Usage: 1) Reuse an existing class, 2) But we can reuse because the combination of such classes result in an incompatible interface.
	 * 
	 * Structure: Client -> Adapter (class that implements Adapter interface) -> Adaptee (legacy set of classes and/or interfaces).
	 * 
	 * *** Most Important *** : Key here is that Client is not able to communicate with Legacy system directly, hence it needs an adapter to
	 * the legacy system. This is different from Facade pattern where Client can actually talk to subsystem directly too.
	 * 
	 * *** Examples from Java Libraries: Arrays.asList(), Collections.List(), InputStreamReader(InputStream), etc.
	 * https://stackoverflow.com/questions/1673841/examples-of-gof-design-patterns-in-javas-core-libraries/2707195
	 */

	public static void main(String[] args) {

		Client client = new Client();

		// Dealing with LegacyRectangle via adapter - assume that Client could otherwise not able to call
		// LegacyRectangle method.
		
		LegacyRectangle legacyRectangle = new LegacyRectangle();
		LegacyRectangleAdapter adapter = new LegacyRectangleAdapter(legacyRectangle);
		client.calculateRectangleSize(adapter);

		// Dealing with Rectangle
		Rectangle rectangle = new Rectangle();
		client.calculateRectangleSize(rectangle);

		// Note: You can not do below since client.calculateRectangleSize method takes an instance or a subclass of
		// Rectagle and not of LegacyRectangle. Hence, you need a "wrapper" around LegacyRectangle
		// (the LegacyRectangleAdaptor) here which extends Rectangle, like above.
//		LegacyRectangle legecyRectangle = new LegacyRectangle();
//		client.calculateRectangleSize(legacyRectangle);

	}

	public void calculateRectangleSize(Rectangle rectangle) {
		System.out.println("Rectangle size is: " + rectangle.determineSize());
	}

}
