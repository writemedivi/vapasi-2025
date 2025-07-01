public class Child extends Parent {

    String childName;
    String education;

    Child(String childName, String education, String parentName, String occupation, String grantParentName, int medicalHistoryCount, String place) {
        super(parentName, occupation, grantParentName, medicalHistoryCount, place);
        this.childName = childName;
        this.education = education;
        System.out.println("Child Constructor Called ..");
        showEntireFamilyDetail();
    }

    void showChildDetails() {
        System.out.println("Child Name : " + childName);
        System.out.println("Education : " + education);
    }

    void showEntireFamilyDetail() {
        showGrandParentDetails();
        getResidenceDetail();
        showParentDetails();
        showChildDetails();
        System.out.println("End of family detail...");
    }

}