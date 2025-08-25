package com.tech.subash.design.patterns.decorator;

public class CoffeeDecoratorAccess {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription());
        System.out.println(coffee.getPrice());

        Coffee coffeeWithMilk = new MilkDecorator(new SimpleCoffee());
        System.out.println(coffeeWithMilk.getDescription());
        System.out.println(coffeeWithMilk.getPrice());

        Coffee coffeeWithMilkAndSugar = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println(coffeeWithMilkAndSugar.getDescription());
        System.out.println(coffeeWithMilkAndSugar.getPrice());
    }
}
