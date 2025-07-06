package com.tw.service;

import com.tw.bean.Expense;
import com.tw.bean.Settlement;

import java.util.*;
import java.util.logging.Logger;

public class ExpenseService {
    static final Logger LOGGER = Logger.getLogger(ExpenseService.class.getName());

    public Map<String, Double> getBalanceSheet(List<Expense> expenses) {

        Map<String, Double> balances = new HashMap<>();

        for (Expense expense : expenses) {
            List<String> participants = expense.expenseSharedPersons();

            if (participants == null || participants.isEmpty()) {
                LOGGER.severe("Expense must have at least one participant.");
                throw new IllegalArgumentException("Expense must have at least one participant.");
            }
            double shareAmount = expense.expenseAmount() / participants.size();

            for (String person : expense.expenseSharedPersons()) {
                balances.put(person, balances.getOrDefault(person, 0.0) - shareAmount);
            }

            String paidBy = expense.expensePaidBy();
            balances.put(paidBy, balances.getOrDefault(paidBy, 0.0) + expense.expenseAmount());
        }

        return balances;


    }

    public List<Settlement> sequentialSettleUp(List<Expense> expenses) {
        List<Settlement> settlements = new ArrayList<>();

        for (Expense expense : expenses) {
            String paidBy = expense.expensePaidBy();
            double amount = expense.expenseAmount();
            List<String> participants = expense.expenseSharedPersons();

            if (participants == null || participants.isEmpty()) {
                throw new IllegalArgumentException("Expense must have at least one participant.");
            }
            double share = amount / participants.size();

            for (String person : participants) {
                if (!person.equals(paidBy)) {
                    settlements.add(new Settlement(person, paidBy, share));
                }
            }
        }
        return settlements;
    }

    public List<Settlement> simplifiedSettleUp(Map<String, Double> balances) {
        PriorityQueue<Map.Entry<String, Double>> creditors = new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));
        PriorityQueue<Map.Entry<String, Double>> debtors = new PriorityQueue<>(Map.Entry.comparingByValue());
        List<Settlement> settlements = new ArrayList<>();

        for (Map.Entry<String, Double> entry : balances.entrySet()) {
            double rounded = Math.round(entry.getValue() * 100.0) / 100.0;
            if (rounded > 0) {
                creditors.add(new AbstractMap.SimpleEntry<>(entry.getKey(), rounded));
            } else if (rounded < 0) {
                debtors.add(new AbstractMap.SimpleEntry<>(entry.getKey(), rounded));
            }
        }

        while (!creditors.isEmpty() && !debtors.isEmpty()) {
            Map.Entry<String, Double> creditor = creditors.poll();
            Map.Entry<String, Double> debtor = debtors.poll();
            if (creditor != null && debtor != null) {
                double amount = Math.min(creditor.getValue(), -debtor.getValue());
                settlements.add(new Settlement(debtor.getKey(), creditor.getKey(), amount));

                double remainingCreditor = creditor.getValue() - amount;
                double remainingDebtor = debtor.getValue() + amount;
                if (Math.abs(remainingCreditor) > 0.01) {
                    creditors.add(new AbstractMap.SimpleEntry<>(creditor.getKey(), remainingCreditor));
                }
                if (Math.abs(remainingDebtor) > 0.01) {
                    debtors.add(new AbstractMap.SimpleEntry<>(debtor.getKey(), remainingDebtor));
                }

            }


        }

        return settlements;
    }
}