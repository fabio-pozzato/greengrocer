package com.solaris.greengrocer;

import com.solaris.greengrocer.model.Fruit;
import com.solaris.greengrocer.service.DiscountProcessor;
import com.solaris.greengrocer.service.ReceiptHelper;
import com.solaris.greengrocer.service.ShoppingCartLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GreengrocerStartup implements ApplicationRunner {

    private final ShoppingCartLoader shoppingCartLoader;

    private final DiscountProcessor discountProcessor;

    private final ReceiptHelper receiptHelper;

    @Autowired
    public GreengrocerStartup(ShoppingCartLoader shoppingCartLoader, DiscountProcessor discountProcessor, ReceiptHelper receiptHelper) {
        this.shoppingCartLoader = shoppingCartLoader;
        this.discountProcessor = discountProcessor;
        this.receiptHelper = receiptHelper;
    }

    @Override
    public void run(ApplicationArguments args) {

        List<Fruit> fruits = shoppingCartLoader.loadFruitItems();

        for (Fruit fruit : fruits) {
            double discountedPrice = discountProcessor.getDiscountedTotal(fruit);
            fruit.setDiscountedCost(discountedPrice);
        }

        double shoppingCartCost = 0;
        for (Fruit fruit : fruits) {
            shoppingCartCost += fruit.getDiscountedCost();
        }

        receiptHelper.logReceipt(fruits, shoppingCartCost);
    }
}
