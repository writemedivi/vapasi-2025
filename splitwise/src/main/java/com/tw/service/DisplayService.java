package com.tw.service;

import com.tw.bean.Expense;
import com.tw.bean.Settlement;

import java.util.List;
import java.util.logging.Logger;

public class DisplayService {
    static final Logger LOGGER = Logger.getLogger(DisplayService.class.getName());

    public void displayExpense(String title, List<Expense> expenseList) {
        LOGGER.info("-----------------------EXPENSE------------------------");
        LOGGER.info(title);
        for (Expense expense : expenseList) {
            LOGGER.info(expense.toString());
        }
        LOGGER.info("---------------------------------------------------------");
    }
    public void displaySettlement(String title, List<Settlement> settlementList) {
        LOGGER.info("-----------------------SETTLEMENT------------------------");
        LOGGER.info(title);
        for (Settlement settlement : settlementList) {
            LOGGER.info(settlement.toString());
        }
        LOGGER.info("---------------------------------------------------------");
    }
}
