package com.tech.subash.design.patterns.decorator;

public abstract class CoffeeDecorator implements Coffee {

    protected Coffee decoratedCofee;

    public CoffeeDecorator(Coffee coffee){
        this.decoratedCofee = coffee;
    }

    @Override
    public int getPrice() {
        return decoratedCofee.getPrice();
    }

    @Override
    public String getDescription() {
        return decoratedCofee.getDescription();
    }
}
