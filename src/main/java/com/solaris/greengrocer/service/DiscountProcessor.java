package com.solaris.greengrocer.service;

import com.solaris.greengrocer.model.Fruit;
import com.solaris.greengrocer.model.discount.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The class takes care of calculating the correct discount for the specific {@link Fruit}. To add an additional
 * discount logic update the {@link Discount.Type} and implement the {@link Discount} interface.
 */
@Component
public class DiscountProcessor {

    private List<Discount> discounts;

    @Autowired
    public DiscountProcessor(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public double getDiscountedTotal(Fruit fruit) {

        for (Discount discount : discounts) {
            if (fruit.getDiscountType() == discount.getType()) {
                return discount.getDiscountedTotal(fruit);
            }
        }
        throw new RuntimeException("Fruit " + fruit.getName() + " has invalid discount: " + fruit.getDiscountType());
    }
}
