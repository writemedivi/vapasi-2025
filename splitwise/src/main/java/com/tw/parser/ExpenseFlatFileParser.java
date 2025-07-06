package com.tw.parser;

import com.tw.bean.Expense;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ExpenseFlatFileParser implements ExpenseParser {
    static final Logger LOGGER = Logger.getLogger(ExpenseFlatFileParser.class.getName());

    public List<Expense> parse(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines()
                    .filter(line -> !line.trim().isEmpty())
                    .map(this::parseLine)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read expenses from input stream", e);
        }
    }

    private Expense parseLine(String line) {

        try {
            String[] parts = line.split(" for ");
            if (parts.length != 3) {
                throw new RuntimeException("Skipping malformed line: " + line);
            }
            String[] spentParts = parts[0].split(" ");

            String paidBy = spentParts[0].trim();
            double amount = Double.parseDouble(spentParts[2]);

            String[] participants = parts[2].split(",");

            List<String> expenseSharedPersons = Arrays.stream(participants)
                    .map(String::trim)
                    .collect(Collectors.toList());
            return new Expense(paidBy, amount, expenseSharedPersons);
        } catch (Exception e) {
            LOGGER.severe("Error parsing line: " + line );
            throw new RuntimeException("Error Occurred during parsing input");
        }
    }
}
