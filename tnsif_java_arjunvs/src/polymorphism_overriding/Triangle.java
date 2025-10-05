package polymorphism_overriding;
public class Triangle extends Shape {
    private double base;
    private double height;

    // Constructor for Triangle
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public void draw() {
        System.out.println("Drawing a triangle with base " + base + " and height " + height);
    }

    public void erase() {
        System.out.println("Erasing a triangle with base " + base + " and height " + height);
    }
}
