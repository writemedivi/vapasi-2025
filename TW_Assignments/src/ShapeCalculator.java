abstract class Shape {
     abstract float calculateArea();
     abstract float calculatePerimeter();

}

class Circle extends Shape {

     int radius;
     float pi = 3.14f;
     Circle(int radius){
         this.radius = radius;
     }
    @Override
    float calculateArea() {
        return (pi * radius *  radius);
    }

    @Override
    float calculatePerimeter(){
        return (2 * pi * radius);
    }
}

class Rectangle extends Shape {

     int length;
     int width ;

     Rectangle (int length, int width){
         this.length = length;
         this.width = width;
     }

    @Override
    float calculateArea() {
        return (length * width );
    }

    @Override
    float calculatePerimeter(){
        return (2 * (length + width) );
    }

    float setDimensions(float length , float breadth ){
         return length * breadth ;
    }

    float setDimensions(float length  ){
        return length * length ;
    }


}

class Triangle extends Shape {
     float side1 ;
     float side2 ;
     float side3 ;


     Triangle (float side1, float side2, float side3){
         this.side1 = side1;
         this.side2 = side2 ;
         this.side3 = side3 ;
     }
    @Override
    float calculateArea() {
        return ( side1 * side2 );
    }

    @Override
    float calculatePerimeter(){
        return (side1 * side2 * side3);
    }
}

public class ShapeCalculator  {

    public static void main(String[] args) {

        Shape[] shape = new Shape[3];
        shape[0]  = new Circle(4);
        shape[1] = new Rectangle(4 , 5);
        shape[2] = new Triangle(2.1f , 4 , 5);

        for (Shape s : shape){
            System.out.println("Calculated area "+ s.getClass().getName() + " : " + s.calculateArea());
            System.out.println("Calculated perimeter "+ s.getClass().getName() + " : " + s.calculatePerimeter());

        }


    }

}