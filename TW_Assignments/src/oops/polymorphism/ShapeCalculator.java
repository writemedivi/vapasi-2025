package oops.polymorphism;

public class ShapeCalculator {
    public static void main(String[] args) {

        Shape[] shape = new Shape[3];
        shape[0] = new Circle(4);
        shape[1] = new Rectangle(8, 4);
        shape[2] = new Triangle(2.1f, 4, 5);

        for (Shape s : shape) {
            String shapeName = s.getClass().getSimpleName();
            if(s instanceof Rectangle){
                if(((Rectangle) s).isSquare){
                    System.out.println("Rectangle is a Square");
                    shapeName = "Square";
                }

            }
            System.out.println("Calculated area for " + shapeName + " : " + s.calculateArea());
            System.out.println("Calculated perimeter for " + shapeName + " : " + s.calculatePerimeter());

        }
    }

}
