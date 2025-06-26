package oops;

class GrandParent {

    String familyName ;
    int medicalHistory;

    GrandParent(){
        System.out.println("Generation of grand parents");
    }

    GrandParent(String familyName , int medicalHistory){
        this();
        this.familyName = familyName;
        this.medicalHistory = medicalHistory ;
        show();
        displayKids(5);
    }

    void show(){
        System.out.println("Family name is " + familyName + ", and no.of medical history " + medicalHistory );
    }

    void displayKids(int noOfKids){
        System.out.println( "Grand parents of family " + familyName + " have " + noOfKids + " number of kids");
    }


}

class Parent extends GrandParent {

    String motherName ;
    String occupation ;

    Parent () {
        super("Selvaraj" , 2);
        System.out.println("80's parents");
        parentDetails();
    }

    Parent(String  motherName , String occupation){
        this();
        this.motherName = motherName;
        this.occupation = occupation ;

    }

    void parentDetails(){
        System.out.println("Father Name is " + motherName + ", and his occupation is " + occupation);
    }

    boolean isDiabetic(){
        return true;
    }


}

class Child extends  Parent{

    String childName ;
    String degree;

    Child(){
        super();
        System.out.println("2k Kids");
    }

    Child(String childName , String degree){
        this();
        this.childName = childName;
        this.degree = degree ;
this.childDetails();
    }

    void childDetails(){

        System.out.println("Child Name is " + childName + ", and he is pursuing " + degree);
        displaySiblings(1);
    }

    void displaySiblings(int noOfSiblings){
        System.out.println( "Child " + childName +" is having " + noOfSiblings + "number of siblings") ;
    }

}

public class Family extends Child {
    public static void main(String[] args) {
        Child obj = new Child("Leo" , " 1st Grade");
    }
}
