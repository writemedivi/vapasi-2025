package com.tw.service;

import com.tw.bean.Expense;
import com.tw.bean.Settlement;

import java.util.*;
import java.util.logging.Logger;

public class ExpenseService {
    static final Logger LOGGER = Logger.getLogger(ExpenseService.class.getName());
    private static final double ROUNDING_SCALE = 100.0;
    private static final double MINIMUM_SETTLEMENT_THRESHOLD = 0.01;
    private static final double DEFAULT_BALANCE = 0.0;
    private static final double ZERO_THRESHOLD = 0.0;

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
                balances.put(person, balances.getOrDefault(person, DEFAULT_BALANCE) - shareAmount);
            }

            String paidBy = expense.expensePaidBy();
            balances.put(paidBy, balances.getOrDefault(paidBy, DEFAULT_BALANCE) + expense.expenseAmount());
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
            double rounded = Math.round(entry.getValue() * ROUNDING_SCALE) / ROUNDING_SCALE;
            if (rounded > ZERO_THRESHOLD) {
                creditors.add(new AbstractMap.SimpleEntry<>(entry.getKey(), rounded));
            } else if (rounded < ZERO_THRESHOLD) {
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
                if (Math.abs(remainingCreditor) > MINIMUM_SETTLEMENT_THRESHOLD) {
                    creditors.add(new AbstractMap.SimpleEntry<>(creditor.getKey(), remainingCreditor));
                }
                if (Math.abs(remainingDebtor) > MINIMUM_SETTLEMENT_THRESHOLD) {
                    debtors.add(new AbstractMap.SimpleEntry<>(debtor.getKey(), remainingDebtor));
                }

            }


        }

        return settlements;
    }
}