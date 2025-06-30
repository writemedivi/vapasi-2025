package oops.polymorphism;
import static java.lang.Math.*;
public class Circle extends Shape {

    int radius;
    float pi = (float) PI;
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
