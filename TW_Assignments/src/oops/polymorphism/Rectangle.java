package oops.polymorphism;

public class Rectangle extends Shape {

    int length;
    int breadth ;
    boolean isSquare;

    Rectangle (int length, int breadth){
        this.length = length;
        this.breadth = breadth;
        this.isSquare = (length == breadth);

    }

    @Override
    float calculateArea() {
        if(!isSquare) {
           return setDimensions(length, breadth);

        }
        else {
           return setDimensions(length);
        }
    }

    @Override
    float calculatePerimeter(){
        return (2 * (length + breadth) );
    }

    float setDimensions(float length , float breadth ){
        return length * breadth ;
    }

    float setDimensions(float length  ){
        return 4 * length ;
    }


}
