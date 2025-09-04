package com.finance.saas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finance.saas.entity.TransactionMessage;

public interface TransactionRepository extends JpaRepository<TransactionMessage, Long> {
}
