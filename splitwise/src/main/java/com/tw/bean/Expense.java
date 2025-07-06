package com.tw.bean;

import java.util.List;

public class Expense {
    private final String expensePaidBy;
    private final double expenseAmount;
    private final List<String> expenseSharedPersons;

    public Expense(String expensePaidBy, double expenseAmount, List<String> expenseSharedPersons) {
        this.expensePaidBy = expensePaidBy;
        this.expenseSharedPersons = expenseSharedPersons;
        this.expenseAmount = expenseAmount;
    }

    public String getExpensePaidBy() {
        return expensePaidBy;
    }

    public List<String> getExpenseSharedPersons() {
        return expenseSharedPersons;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    @Override
    public String toString() {
        return expensePaidBy + " spent " + expenseAmount + " for " + expenseSharedPersons;

    }
}
