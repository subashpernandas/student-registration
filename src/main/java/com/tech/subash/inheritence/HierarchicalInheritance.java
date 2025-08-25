package com.tech.subash.inheritence;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class AnimalO {
    void eat() {
        log.info("Animal eats");
    }
}

@Slf4j
class DogO extends Animal {
    void bark() {
        log.info("Dog barks");
    }
}

@Slf4j
class CatO extends Animal {
    void meow() {
        log.info("Cat meows");
    }
}

public class HierarchicalInheritance {

    public static void main(String[] args) {
        DogO dog = new DogO();
        dog.eat();   // inherited from Animal
        dog.bark();  // Dog's own method

        CatO cat = new CatO();
        cat.eat();   // inherited from Animal
        cat.meow();  // Cat's own method
    }
}
