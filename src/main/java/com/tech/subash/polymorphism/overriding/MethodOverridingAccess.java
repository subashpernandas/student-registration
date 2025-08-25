package com.tech.subash.polymorphism.overriding;


public class MethodOverridingAccess {
    public static void main(String[] args) {
        Animal a = new Dog();  // UpCasting  => Every Dog is an Animal
        a.sound();

        Animal aa =  a;  // UpCast
        aa.sound();

        Dog d = (Dog) a;//Downcast
        d.watchGuard();
        d.sound();
    }
}
