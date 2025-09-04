package com.finance.saas.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.finance.saas.entity.TransactionMessage;

@Service
public class TransactionService {

    public TransactionMessage categorize(TransactionMessage sms) {

        Pattern amountPattern = Pattern.compile("(?i)(?:Rs|INR)\\s?([0-9]+(?:\\.[0-9]{1,2})?)");
        Matcher m = amountPattern.matcher(sms.getContent());
        if (m.find()) {
            sms.setAmount(Double.valueOf(m.group(1)));
        }

        String text = sms.getContent().toLowerCase();
        if (text.contains("swiggy") || text.contains("zomato")) {
            sms.setCategory("FOOD");
        } else if (text.contains("amazon") || text.contains("flipkart")) {
            sms.setCategory("SHOPPING");
        } else if (text.contains("upi") || text.contains("imps")) {
            sms.setCategory("TRANSFER");
        } else if (text.contains("debited")) {
            sms.setCategory("EXPENSE");
        } else if (text.contains("credited")) {
            sms.setCategory("INCOME");
        } else {
            sms.setCategory("OTHER");
        }

        return sms;
    }
}
