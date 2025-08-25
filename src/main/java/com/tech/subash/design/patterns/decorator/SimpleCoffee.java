package com.tech.subash.design.patterns.decorator;

public class SimpleCoffee implements Coffee {
    @Override
    public int getPrice() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Simple Coffee, If you want more you can add you have to pay for that!";
    }
}
