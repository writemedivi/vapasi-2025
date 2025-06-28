package oops.Association;

import java.util.ArrayList;
import java.util.List;

public class UserLaptop {
    private static List<Laptop> laptopList = new ArrayList<>();

    public static void main(String[] args) {

        addLaptopSpecification(laptopList);
        displayUserLaptopSpec();


    }
    private static void addLaptopSpecification(List<Laptop> laptopList){

        laptopList.add(
                new Laptop( new HardDisk("2 TB", "SSD"),
                        new Ram(64 , 3200),
                        new Processor("M1 Air")
                ));

        laptopList.add(new Laptop(
                new HardDisk("1 TB", "Mechanical"),
                new Ram(128, 2400),
                new Processor("M3 Pro")
        ));
    }

    private static void displayUserLaptopSpec(){
        int userCount = 0;
        for(Laptop laptop : laptopList){
            userCount ++;
            System.out.println("**********  Laptop Specification for User " + userCount + " **************");
            System.out.println(laptop);
        }


    }
}