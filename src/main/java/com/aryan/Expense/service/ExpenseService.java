package com.aryan.Expense.service;

import com.aryan.Expense.model.Expense;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExpenseService {

    private Map<Integer, Expense> expenseMap = new HashMap<>();
    private int idCounter = 1;

    // Create
    public Expense addExpense(Expense expense) {
        expense.setId(idCounter++);
        expenseMap.put(expense.getId(), expense);
        return expense;
    }

    // Read
    public Collection<Expense> getAllExpenses() {
        return expenseMap.values();
    }

    // Update
    public boolean updateExpense(int id, Expense expense) {
        if (!expenseMap.containsKey(id)) {
            return false;
        }
        expense.setId(id);
        expenseMap.put(id, expense);
        return true;
    }

    // Delete
    public boolean deleteExpense(int id) {
        return expenseMap.remove(id) != null;
    }
}
