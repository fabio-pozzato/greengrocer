package com.solaris.greengrocer.model.discount;

import com.solaris.greengrocer.model.Fruit;

public interface Discount {

    double getDiscountedTotal(Fruit fruit);

    Discount.Type getType();

    enum Type {
        NONE,
        BUY_3X2
    }
}
