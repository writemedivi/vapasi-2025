package oops.Association;

public class Laptop {
    final  String logo = "Mac";

    HardDisk hardDisk ;
    Ram ram ;
    Processor processor;

    Laptop(HardDisk hardDisk , Ram ram , Processor processor){
        this.hardDisk = hardDisk;
        this.ram = ram;
        this.processor = processor;
    }

    public void displayLaptopSpec(){
        System.out.println("Laptop Logo : " + logo);
//        System.out.println("Laptop HardDisk size : " + hardDisk.getSize() + " and type : " + hardDisk.getType());
//        System.out.println("Laptop Ram size : " + ram.getSize() + " and speed in GHZ: " + ram.getSpeedInGHZ());
//        System.out.println("Laptop Processor model : " + processor.getModel());

    }

    @Override
    public String toString() {
        return ram + "\n" + hardDisk + "\n" + processor;
    }

}
