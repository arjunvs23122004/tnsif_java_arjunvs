package com.tnsif.interfacedemo;

 interface Shape{
	 
	void draw();
}

public class InterfaceDemo implements Shape{
	
	public void draw() {
		System.out.println("Drawing a circle in an interface");
	}

	public static void main(String[] args) {
	
		InterfaceDemo id = new InterfaceDemo();
		id.draw();
		

		
	}

}
