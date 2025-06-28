package oops.Association;

public class HardDisk {

    private String size;
    private String type;

    public HardDisk(String size, String type) {
        this.size = size;
        this.type = type;
    }


    @Override
    public String toString() {
        return "HardDisk: " + type + ", Size: " + size;
    }

}
