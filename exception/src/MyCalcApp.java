import java.util.Scanner;

public class MyCalcApp {

    public static void main(String[] args) {
        MyCalcApp calcApp = new MyCalcApp();
        calcApp.runCalculateApp();
    }

    private void runCalculateApp() {
        int number = getInput();
        double result = calculate(number);
        showOutput(result);
    }

    private int getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input : ");
        return scanner.nextInt();
    }

    private double calculate(int number) {
        Calculator calculator = new Calculator();
        return calculator.calDouble(number);

    }

    private void showOutput(double result) {
        System.out.println("Result after calculation : " + result);
    }

}
