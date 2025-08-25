package com.tech.subash.inheritence;

import lombok.extern.slf4j.Slf4j;

interface A {
    void method();
}

interface C {
    void method();
}

@Slf4j
class B {
    void methodB() {
        log.info("Method from class B");
    }
}


/*
class D extends B      => This is single inheritance
class D implements A,C => This is multiple inheritance using interfaces.
                which is allowed in Java because interfaces don’t carry implementation state
                           (no ambiguity like with classes).

  Combining class inheritance (extends) and interface inheritance (implements) is called Hybrid inheritance.
 */

@Slf4j
class D extends B implements A, C {

    @Override
    public void method() {
       log.info("if Two Methods has same method Signature Its own Implementation");
    }
}

public class HybridInheritance {
    public static void main(String[] args) {
        D obj = new D();
        obj.method();
        obj.methodB();
    }
}
