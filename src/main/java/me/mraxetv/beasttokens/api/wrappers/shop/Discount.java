package me.mraxetv.beasttokens.api.wrappers.shop;

import lombok.Getter;

public abstract class Discount {
    protected double amount;
    @Getter
    protected int priority;

    public Discount(double amount,int priority) {
        this.amount = amount;
        this.priority = priority;
    }

    public abstract double applyDiscount(double originalPrice);

    public abstract String getDiscountAmountFormated();

    public abstract String getType();

}

