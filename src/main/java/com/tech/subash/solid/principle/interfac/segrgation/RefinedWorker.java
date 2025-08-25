package com.tech.subash.solid.principle.interfac.segrgation;

public class RefinedWorker implements RefinedWorkable, RefinedEatable{
    @Override
    public void eat() {
      System.out.println("Worker Can Eat");
    }

    @Override
    public void work() {
        System.out.println("Worker Can work");
    }
}
