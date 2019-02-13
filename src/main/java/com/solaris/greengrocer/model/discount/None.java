package com.solaris.greengrocer.model.discount;

import com.solaris.greengrocer.model.Fruit;
import org.springframework.stereotype.Component;

@Component
public class None implements Discount {

    /**
     * @param fruit
     * @return The discounted total is equal to the total cost, as there is no discount available
     */
    @Override
    public double getDiscountedTotal(Fruit fruit) {

        return fruit.getTotalCost();
    }

    @Override
    public Type getType() {

        return Type.NONE;
    }
}
