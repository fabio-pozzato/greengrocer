package com.solaris.greengrocer.model.discount;

import com.solaris.greengrocer.model.Fruit;
import com.solaris.greengrocer.service.DiscountProcessor;
import org.junit.Assert;
import org.junit.Test;
import java.util.Collections;

public class Buy3X2Test {

    @Test
    public void test3X2Discount() {

        Fruit papaya = new Fruit("papaya", 0.5, Discount.Type.BUY_3X2 );
        DiscountProcessor dp = new DiscountProcessor(Collections.singletonList(new Buy3X2()));

        papaya.setAmount(0);
        Assert.assertEquals(0, dp.getDiscountedTotal(papaya), 0);

        papaya.setAmount(1);
        Assert.assertEquals(0.5, dp.getDiscountedTotal(papaya), 0);

        papaya.setAmount(2);
        Assert.assertEquals(1, dp.getDiscountedTotal(papaya), 0);

        papaya.setAmount(3);
        Assert.assertEquals(1, dp.getDiscountedTotal(papaya), 0);

        papaya.setAmount(4);
        Assert.assertEquals(1.5, dp.getDiscountedTotal(papaya), 0);

        papaya.setAmount(5);
        Assert.assertEquals(2, dp.getDiscountedTotal(papaya), 0);

        papaya.setAmount(6);
        Assert.assertEquals(2, dp.getDiscountedTotal(papaya), 0);

        papaya.setAmount(7);
        Assert.assertEquals(2.5, dp.getDiscountedTotal(papaya), 0);
    }

    @Test
    public void testNoDiscount() {

        Fruit banana = new Fruit("banana", 0.5);
        DiscountProcessor dp = new DiscountProcessor(Collections.singletonList(new None()));

        banana.setAmount(1);
        Assert.assertEquals(0.5, dp.getDiscountedTotal(banana), 0);

        banana.setAmount(2);
        Assert.assertEquals(1, dp.getDiscountedTotal(banana), 0);

        banana.setAmount(3);
        Assert.assertEquals(1.5, dp.getDiscountedTotal(banana), 0);
    }
}