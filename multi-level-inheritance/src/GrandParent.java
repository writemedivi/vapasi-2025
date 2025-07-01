class GrandParent {

    String familyName;
    int medicalHistory;
    private final String place;

    GrandParent(String familyName, int medicalHistory, String place) {
        this.familyName = familyName;
        this.medicalHistory = medicalHistory;
        this.place = place;
        System.out.println("Grand Parents Constructor Called..");

    }


    void showGrandParentDetails() {
        System.out.println("Grand Parent Family Name : " + familyName);
        System.out.println("Number of medical history : " + medicalHistory);
    }

    void getResidenceDetail() {
        System.out.println("Grand parents residing in " + this.place);
    }


}
