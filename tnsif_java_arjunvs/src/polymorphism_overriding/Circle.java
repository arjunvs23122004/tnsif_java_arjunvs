package polymorphism_overriding;

public class Circle extends Shape {
	private double radius;

	// Constructor for Circle
	public Circle(double radius) {
		this.radius = radius;
	}
	public void draw() {
		System.out.println("Drawing a circle with radius " + radius);
	}
	public void erase() {
		System.out.println("Erasing a circle with radius " + radius);

	}

}
