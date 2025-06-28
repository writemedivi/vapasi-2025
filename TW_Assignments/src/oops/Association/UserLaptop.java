package oops.Association;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class UserLaptop {
    public static void main(String[] args) {

        List<Laptop> laptopList = new ArrayList<>();

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

        int userCount = 0;
        for(Laptop laptop : laptopList){
            userCount ++;
            System.out.println("**********  Laptop Specification for User " + userCount + " **************");
            laptop.displayLaptopSpec();
        }


    }
}