package oops.polymorphism;

public class Circle extends Shape {

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
