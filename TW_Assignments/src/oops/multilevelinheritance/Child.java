package oops.multilevelinheritance;

public class Child extends Parent {

    String childName ;
    String education;


    Child(String childName , String education, String parentName , String occupation, String grantParentName , int medicalHistoryCount){
        super(parentName, occupation, grantParentName, medicalHistoryCount);
        this.childName = childName;
        this.education = education ;
        System.out.println("Child Constructor Called ..");
        showEntireFamilyDetail();
    }

    void showchildDetails(){
        System.out.println("Child Name : " + childName );
        System.out.println("Education : " + education);
    }

    void showEntireFamilyDetail(){
        showGrandParentDetails();
        getResidenceDetail("India");
        showparentDetails();
        isDiabetic(false);
        showchildDetails();
        System.out.println("End of family detail...");
    }

}