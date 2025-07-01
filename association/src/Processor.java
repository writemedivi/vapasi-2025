public class Processor {

    private final String model;

    Processor(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Processor Model : " + model;
    }


}
