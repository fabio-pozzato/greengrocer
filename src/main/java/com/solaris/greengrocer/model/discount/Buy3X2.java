package com.solaris.greengrocer.model.discount;


import com.solaris.greengrocer.model.Fruit;
import org.springframework.stereotype.Component;

@Component
public class Buy3X2 implements Discount {

    public double getDiscountedTotal(Fruit fruit) {

        double result = 0;

        double unitPrice = fruit.getUnitPrice();
        int amount = fruit.getAmount();

        double leftovers = (double)amount % 3;
        result += leftovers * unitPrice;
        result += (amount - leftovers - amount/3) * unitPrice;
        return result;
    }

    @Override
    public Type getType() {

        return Type.BUY_3X2;
    }
}
