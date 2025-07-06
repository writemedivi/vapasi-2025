package com.tw.parser;

import com.tw.bean.Expense;
import java.io.InputStream;
import java.util.List;

public interface ExpenseParser {
    List<Expense> parse(InputStream inputStream);
}
