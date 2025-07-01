public class Ram {
    private final int size;
    private final int speedInGHZ;

    Ram(int size, int speedInGHZ) {
        this.size = size;
        this.speedInGHZ = speedInGHZ;
    }

    public int getSize() {
        return size;
    }

    public int getSpeedInGHZ() {
        return speedInGHZ;
    }

    @Override
    public String toString() {
        return "Ram size : " + getSize() + ", Speed in GHZ: " + getSpeedInGHZ();
    }

}
