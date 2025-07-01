public class HardDisk {

    private final String size;
    private final String type;

    public HardDisk(String size, String type) {
        this.size = size;
        this.type = type;
    }

    @Override
    public String toString() {
        return "HardDisk: " + type + ", Size: " + size;
    }

}
