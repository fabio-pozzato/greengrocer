package com.solaris.greengrocer.model;

import com.solaris.greengrocer.model.discount.Discount;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Fruit {

    private String name;
    private double unitPrice;
    private Discount.Type discountType;
    private int amount;
    private Double discountedCost;

    public Fruit(String name, double unitPrice, Discount.Type discountType) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.discountType = discountType;
    }

    public Fruit(String name, double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.discountType = Discount.Type.NONE;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public Discount.Type getDiscountType() {
        return discountType;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Double getDiscountedCost() {
        return discountedCost;
    }

    public void setDiscountedCost(Double discountedCost) {
        this.discountedCost = discountedCost;
    }

    public double getTotalCost() {
        BigDecimal bd = new BigDecimal(unitPrice * amount);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public double getDiscountAmount() {
        return getTotalCost() - getDiscountedCost();
    }
}
