package oops.multilevelinheritance;

class Parent extends GrandParent {

    String parentName;
    String occupation;

    Parent() {

    }

    Parent(String parentName, String occupation, String grandParentName, int medicalHistoryCount) {
        super(grandParentName, medicalHistoryCount);
        this.parentName = parentName;
        this.occupation = occupation;
        System.out.println("Parents Constructor Called ..");

    }

    void showparentDetails() {
        System.out.println("Parent Name : " + parentName);
        System.out.println("Parent Occupation : " + occupation);

    }

    void isDiabetic(boolean result) {
        if(result){
            System.out.println("Parents are diabetic");
        }
        else
            System.out.println("Parents are non diabetic");
    }


}
