package oops.Association;

import java.util.ArrayList;
import java.util.List;
public class ITStore {
    private static List<Laptop> laptopInventory = new ArrayList<>();

    public static void main(String[] args) {
        orderLaptopForUser();
        displayUserLaptopSpecification();

    }
    private static void orderLaptopForUser(){

        laptopInventory.add(
                new Laptop( new HardDisk("2 TB", "SSD"),
                        new Ram(64 , 3200),
                        new Processor("M1"),
                        new User( "Manav")
                ));

        laptopInventory.add(new Laptop(
                new HardDisk("1 TB", "Mechanical"),
                new Ram(128, 2400),
                new Processor("M3"),
                new User( "Dhivya")
        ));
    }

    private static void displayUserLaptopSpecification(){
        for(Laptop laptop : laptopInventory){
            System.out.println("Laptop Specification for User : " + laptop.user.getUserName() );
            System.out.println(laptop + "\n") ;
        }


    }
}