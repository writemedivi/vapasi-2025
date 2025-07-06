package com.tw.bean;

import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Double.compare(expenseAmount, expense.expenseAmount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(expenseAmount);
    }

    @Override
    public String toString() {
        return expensePaidBy + " spent " + expenseAmount + " for " + expenseSharedPersons;

    }
}
