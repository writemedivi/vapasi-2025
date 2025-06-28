package oops.Association;

public class Laptop {
    final String logo;
    HardDisk hardDisk ;
    Ram ram ;
    Processor processor;
    User user ;

    Laptop(HardDisk hardDisk , Ram ram , Processor processor, User user ){
        this.logo = "Mac";
        this.hardDisk = hardDisk;
        this.ram = ram;
        this.processor = processor;
        this.user = user ;
    }



    @Override
    public String toString() {
        return   ram + "\n" + hardDisk + "\n" + processor;
    }

}
