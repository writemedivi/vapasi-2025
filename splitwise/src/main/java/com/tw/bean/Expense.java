package com.tw.bean;

import java.util.List;
import java.util.Objects;

public record Expense(String expensePaidBy, double expenseAmount, List<String> expenseSharedPersons) {

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
