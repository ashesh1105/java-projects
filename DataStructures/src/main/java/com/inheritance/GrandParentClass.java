package com.inheritance;

public class GrandParentClass {

	public void methodA(){
		System.out.println("GrandParentClass");
	}
	
	public void parentMethod(GrandParentClass G){
		
		System.out.println("GrandParent");
	}
}
