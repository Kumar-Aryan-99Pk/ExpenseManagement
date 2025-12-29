package com.aryan.Expense.controller;

import com.aryan.Expense.model.Expense;
import com.aryan.Expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // POST /expenses
    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    // GET /expenses
    @GetMapping
    public Collection<Expense> getExpenses() {
        return expenseService.getAllExpenses();
    }

    // PUT /expenses/{id}
    @PutMapping("/{id}")
    public String updateExpense(@PathVariable int id, @RequestBody Expense expense) {
        boolean updated = expenseService.updateExpense(id, expense);
        return updated ? "Expense updated successfully" : "Expense not found";
    }

    // DELETE /expenses/{id}
    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable int id) {
        boolean deleted = expenseService.deleteExpense(id);
        return deleted ? "Expense deleted successfully" : "Expense not found";
    }
}
