package com.tw.bean;

public class Settlement {

    private final String paidBy;
    private final String paidTo;
    private final double paidAmount;

    public Settlement(String paidBy, String paidTo, double paidAmount) {
        this.paidBy = paidBy;
        this.paidTo = paidTo;
        this.paidAmount = paidAmount;
    }

    @Override
    public String toString() {
        return paidBy + " pays " + paidTo + " " + Math.round(paidAmount);

    }
}
