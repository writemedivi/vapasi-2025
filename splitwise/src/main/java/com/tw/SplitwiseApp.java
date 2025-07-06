package com.tw;

import com.tw.bean.Expense;
import com.tw.bean.Settlement;
import com.tw.parser.ExpenseFlatFileParser;
import com.tw.parser.ExpenseParser;
import com.tw.service.DisplayService;
import com.tw.service.ExpenseService;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class SplitwiseApp {
    static final Logger LOGGER = Logger.getLogger(SplitwiseApp.class.getName());

    public static void main(String[] args) {
        ExpenseService expenseService = new ExpenseService();
        DisplayService displayService = new DisplayService();
        ExpenseParser expenseParser = new ExpenseFlatFileParser();

        try (InputStream inputStream = SplitwiseApp.class.getClassLoader().getResourceAsStream("transactionDetails.txt")) {
            if (inputStream == null) {
                throw new FileNotFoundException("transactionDetails.txt not found in resources directory.");
            }
            List<Expense> expenses = expenseParser.parse(inputStream);
            displayService.displayExpense("Expenses : ", expenses);

            List<Settlement> sequentialSettleUp = expenseService.sequentialSettleUp(expenses);
            displayService.displaySettlement("Sequential Settle-up", sequentialSettleUp);

            Map<String, Double> balanceSheet = expenseService.getBalanceSheet(expenses);
            List<Settlement> simplifiedSettleUp = expenseService.simplifiedSettleUp(balanceSheet);
            displayService.displaySettlement("Simplified Debt Settle-up", simplifiedSettleUp);

        } catch (Exception exception) {
            LOGGER.severe("Exception Occured : " + exception.getMessage());
        }
    }
}
