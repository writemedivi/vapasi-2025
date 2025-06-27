package oops;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        HardDisk h1 = new HardDisk("2 TB", "s");
        Ram r1 = new Ram(64 , 3200);
        Processor p1 = new Processor("M1 Air");
        Laptop l1 = new Laptop(h1 , r1, p1);
        l1.displayLaptopSpec();

    }
}