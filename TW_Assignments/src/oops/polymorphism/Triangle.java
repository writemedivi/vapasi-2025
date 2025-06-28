package oops.polymorphism;

public class Triangle extends Shape {
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

