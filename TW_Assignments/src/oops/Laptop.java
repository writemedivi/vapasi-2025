package oops;

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
        System.out.println("Laptop spec : Hard disk size - " + hardDisk.getSize() +
                "Hard disk type - " + hardDisk.getType() ) ;
    }


}
