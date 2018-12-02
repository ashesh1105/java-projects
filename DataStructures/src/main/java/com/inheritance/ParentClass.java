package com.inheritance;

public class ParentClass extends GrandParentClass implements Interface {

	@Override
	public void methodA() {
		System.out.println("ParentClass");
	}

	public void eat() throws Exception {
		System.out.println("Parent EAT");
	}

	public void parentMethod(ParentClass G) {
		System.out.println("Parent");
	}

	public void interfaceMethod() {
		System.out.println("Inside Parent Interface Method");
	}

	public static void staticMethod() {
		System.out.println("Parent Static Method");
	}
}
