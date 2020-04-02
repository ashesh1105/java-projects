package com.inheritance;

public class ChildClass extends ParentClass{

	int i;
	
	public void methodB(){
		System.out.println("ChildClass");
	}
	
	@Override
	public void methodA(){
		System.out.println("MethodA ChildClass");
	}
	
	public void parentMethod(ChildClass G){
		System.out.println("Child");
	}
	
    @Override
	public void parentMethod(ParentClass G){
		System.out.println("Child");
	}
    
    @Override
    public void eat() {
		System.out.println("Child EAT");
	}
	
    @Override
	public void interfaceMethod(){
		System.out.println("Inside Child Interface Method");
	}
	
	public static void staticMethod() {
		System.out.println("Chlid Static Method");
	}
    
	public static void main(String[] args) throws Exception {
		
		GrandParentClass childClass = new ChildClass();
		
		// Below is allowed since it is defined in GrandParentClass. It will call child class method.
		childClass.methodA();
		
		// Below will be a compile time error since it is not visible to GrandParentClass (reference)
//		 childClass.methodB();
		
		// Both of below method calls will call GrandParentClass methods! Find out why??
		childClass.parentMethod(new GrandParentClass());
		childClass.parentMethod(new ChildClass());
		
		ChildClass child = new ChildClass();
		// This will call ChildClass method even if reference of parent is passed as argument
		child.parentMethod(new ParentClass());
		
		// Resolved at runtime and child class method is called
		ParentClass p = new ChildClass();
		p.eat();
		
		// Resolved at runtime and child class method is called
		ParentClass c = new ChildClass();
		c.interfaceMethod();
		
	}
	
	/*@Override
	public boolean equals(Object arg0) {
		if(arg0 instanceof ChildClass){
			if(((ChildClass)arg0).i ==  this.i){
				return true;
			}
		}
		return false;
	}*/
	
	@Override
	public int hashCode() {
		return this.i;
	}
}
