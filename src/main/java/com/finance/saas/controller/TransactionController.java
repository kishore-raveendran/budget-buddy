package com.finance.saas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.saas.entity.TransactionMessage;
import com.finance.saas.repository.TransactionRepository;
import com.finance.saas.service.TransactionService;

@RestController
@RequestMapping("/sms")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/save")
    public ResponseEntity<TransactionMessage> saveSms(@RequestBody TransactionMessage sms) {
        TransactionMessage categorized = this.transactionService.categorize(sms);
        return ResponseEntity.ok(transactionRepository.save(categorized));
    }

    @GetMapping("/report/category")
    public Map<String, Double> getExpensesByCategory() {
        List<TransactionMessage> transactions = transactionRepository.findAll();
        Map<String, Double> expensesByCategory = new HashMap<>();

        for (TransactionMessage tx : transactions) {
            String category = tx.getCategory();
            Double amount = tx.getAmount() != null ? tx.getAmount() : 0.0;
            expensesByCategory.put(category,
                    expensesByCategory.getOrDefault(category, 0.0) + amount);
        }
        return expensesByCategory;
    }

    @GetMapping("/sample")
    public String testMethod() {
        return "Sample";
    }
}
