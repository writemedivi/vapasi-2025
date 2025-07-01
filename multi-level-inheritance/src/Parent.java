class Parent extends GrandParent {

    String parentName;
    String occupation;

    Parent(String parentName, String occupation, String grandParentName, int medicalHistoryCount, String place) {
        super(grandParentName, medicalHistoryCount, place);
        this.parentName = parentName;
        this.occupation = occupation;
        System.out.println("Parents Constructor Called ..");

    }

    void showParentDetails() {
        System.out.println("Parent Name : " + parentName);
        System.out.println("Parent Occupation : " + occupation);

    }

}
