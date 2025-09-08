package com.finance.saas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finance.saas.entity.TransactionMessage;
import com.finance.saas.entity.User;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionMessage, Long> {
    
    List<TransactionMessage> findByUser(User user);
    
    List<TransactionMessage> findByUserAndCategory(User user, String category);
    
    @Query("SELECT tm.category, SUM(tm.amount) FROM TransactionMessage tm WHERE tm.user = :user GROUP BY tm.category")
    List<Object[]> findCategoryWiseExpensesByUser(@Param("user") User user);
    
    @Query("SELECT COUNT(tm) FROM TransactionMessage tm WHERE tm.user = :user")
    Long countByUser(@Param("user") User user);
}
