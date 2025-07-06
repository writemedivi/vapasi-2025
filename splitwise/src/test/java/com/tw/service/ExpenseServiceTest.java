package com.tw.service;

import com.tw.bean.Expense;
import com.tw.bean.Settlement;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseServiceTest {
    private final ExpenseService service = new ExpenseService();

    @Test
    void shouldTestGetBalanceSheet() {
        List<Expense> expenses = List.of(
                new Expense("A", 90, List.of("A", "B", "C"))
        );
        Map<String, Double> balances = service.getBalanceSheet(expenses);
        assertEquals(60.0, Math.round(balances.get("A") * 100.0) / 100.0);
        assertEquals(-30.0, Math.round(balances.get("B") * 100.0) / 100.0);
        assertEquals(-30.0, Math.round(balances.get("C") * 100.0) / 100.0);
    }

    @Test
    void shouldTestSequentialSettleUp() {
        List<Expense> expenses = List.of(
                new Expense("A", 100, List.of("A", "B"))
        );

        List<Settlement> settlements = service.sequentialSettleUp(expenses);
        assertEquals(1, settlements.size());
        assertEquals(new Settlement("B", "A", 50.0), settlements.getFirst());
    }

    @Test
    void shouldTestSimplifiedSettleUp() {
        Map<String, Double> balances = new HashMap<>();
        balances.put("A", 60.0);
        balances.put("B", -20.0);
        balances.put("C", -40.0);

        List<Settlement> settlements = service.simplifiedSettleUp(balances);

        assertEquals(2, settlements.size());
        assertTrue(settlements.contains(new Settlement("B", "A", 20.0)));
        assertTrue(settlements.contains(new Settlement("C", "A", 40.0)));
    }

    @Test
    void shouldTestGetBalanceSheetThrowsWhenNoParticipants() {
        List<Expense> expenses = List.of(
                new Expense("A", 100, new ArrayList<>()) // empty participants
        );

        assertThrows(IllegalArgumentException.class, () -> service.getBalanceSheet(expenses));
    }

    @Test
    void shouldTestSequentialSettleUpThrowsWhenNoParticipants() {
        List<Expense> expenses = List.of(
                new Expense("A", 200, List.of()) // empty sharedPersons
        );

        assertThrows(IllegalArgumentException.class, () -> service.sequentialSettleUp(expenses));
    }

    @Test
    void shouldTestSimplifiedSettleUpWithZeroBalance() {
        Map<String, Double> balances = new HashMap<>();
        balances.put("A", 0.0);
        balances.put("B", 0.0);
        List<Settlement> result = service.simplifiedSettleUp(balances);

        assertTrue(result.isEmpty());
    }



}