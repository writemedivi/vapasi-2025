package oops.multilevelinheritance;

class GrandParent {

    String familyName;
    int medicalHistory;

    GrandParent() {
    }

    GrandParent(String familyName, int medicalHistory) {
        this.familyName = familyName;
        this.medicalHistory = medicalHistory;
        System.out.println("Grand Parents Constructor Called..");

    }

    void showGrandParentDetails() {
        System.out.println("Grand Parent Family Name : " + familyName);
        System.out.println("Number of medical history : " + medicalHistory);
    }

     void getResidenceDetail(String place) {
        System.out.println("Grand parents residing in " + place);
    }


}
