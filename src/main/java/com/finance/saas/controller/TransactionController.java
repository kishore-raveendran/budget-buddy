package com.finance.saas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.saas.entity.TransactionMessage;
import com.finance.saas.entity.User;
import com.finance.saas.repository.TransactionRepository;
import com.finance.saas.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/save")
    public ResponseEntity<TransactionMessage> saveSms(
            @RequestBody TransactionMessage sms,
            @AuthenticationPrincipal User currentUser) {

        sms.setUser(currentUser);

        TransactionMessage categorized = this.transactionService.categorize(sms);
        return ResponseEntity.ok(transactionRepository.save(categorized));
    }

    @GetMapping("/report/category")
    public Map<String, Double> getExpensesByCategory(
            @AuthenticationPrincipal User currentUser) {

        List<TransactionMessage> transactions = transactionRepository.findByUser(currentUser);
        Map<String, Double> expensesByCategory = new HashMap<>();

        for (TransactionMessage tx : transactions) {
            String category = tx.getCategory();
            Double amount = tx.getAmount() != null ? tx.getAmount() : 0.0;
            expensesByCategory.put(category,
                    expensesByCategory.getOrDefault(category, 0.0) + amount);
        }
        return expensesByCategory;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TransactionMessage>> getAllTransactions(
            @AuthenticationPrincipal User currentUser) {

        List<TransactionMessage> transactions = transactionRepository.findByUser(currentUser);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getTransactionCount(
            @AuthenticationPrincipal User currentUser) {

        Long count = transactionRepository.countByUser(currentUser);
        return ResponseEntity.ok(count);
    }

}
