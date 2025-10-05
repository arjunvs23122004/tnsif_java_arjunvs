package polymorphism_overriding;

public class Square extends Shape {
    private double side;

    // Constructor
    public Square(double side) {
        this.side = side;
    }

    // Override draw method
    @Override
    public void draw() {
        System.out.println("Drawing a square with side " + side);
    }

    // Override erase method
    @Override
    public void erase() {
        System.out.println("Erasing a square with side " + side);
    }
}
