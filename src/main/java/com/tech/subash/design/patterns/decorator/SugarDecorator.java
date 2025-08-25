package com.tech.subash.design.patterns.decorator;

public class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getPrice() {
        return decoratedCofee.getPrice() + 2;
    }

    @Override
    public String getDescription() {
        return decoratedCofee.getDescription() + " Sugar Added";
    }
}
