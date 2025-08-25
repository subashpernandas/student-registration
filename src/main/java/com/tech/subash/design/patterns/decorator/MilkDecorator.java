package com.tech.subash.design.patterns.decorator;

public class MilkDecorator extends  CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getPrice() {
        return decoratedCofee.getPrice() + 5;
    }

    @Override
    public String getDescription() {
        return decoratedCofee.getDescription() + " Milk Added";
    }
}
