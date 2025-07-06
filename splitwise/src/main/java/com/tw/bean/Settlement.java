package com.tw.bean;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Settlement that = (Settlement) o;
        return Double.compare(paidAmount, that.paidAmount) == 0 && Objects.equals(paidBy, that.paidBy) && Objects.equals(paidTo, that.paidTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paidBy, paidTo, paidAmount);
    }

    @Override
    public String toString() {
        return paidBy + " pays " + paidTo + " " + Math.round(paidAmount);

    }
}
