package ExceptionAssignment;

import java.util.Scanner;

public class MyCalcApp {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        int number ;
        System.out.print("Enter input : ");
        number = scanner.nextInt();
        System.out.println(calculator.caldouble(number));


    }
}
