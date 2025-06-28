package oops.Association;

public class Processor {


    private String model;

    Processor(String model){
        this.model = model;
    }

    @Override
    public String toString() {
        return "Processor Model : " + model  ;
    }


}
