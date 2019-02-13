package com.solaris.greengrocer.service;

import com.solaris.greengrocer.model.Fruit;
import com.solaris.greengrocer.model.discount.Discount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptHelper {

    private Logger logger = LoggerFactory.getLogger(ReceiptHelper.class);

    @Value("${solaris.currency}")
    private String currency;

    public void logReceipt(List<Fruit> fruits, double shoppingCartCost) {

        logger.info("");
        String line = "-------------------------------";
        logger.info(line);
        logger.info(String.format("%18s", "Receipt"));
        logger.info(line);

        for (Fruit fruit : fruits) {
            String log = String.format("%-20s %10s", fruit.getAmount() + "x " + fruit.getName() + " @ "+fruit.getUnitPrice(),
                    fruit.getTotalCost() + " " + currency);
            logger.info(log);

            if (fruit.getDiscountType() != Discount.Type.NONE && fruit.getDiscountAmount() != 0) {
                log = String.format("%31s", "-" + fruit.getDiscountAmount() + " " + currency);
                logger.info(log);
                logger.info(String.format("%31s", "------------"));
                logger.info(String.format("%31s", fruit.getDiscountedCost() + " " + currency));
            }

            logger.info("");
        }

        logger.info(line);
        logger.info(String.format("%-20s %10s", "Total cost:", shoppingCartCost + " " + currency));
    }
}
