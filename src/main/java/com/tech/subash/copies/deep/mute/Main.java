package com.tech.subash.copies.deep.mute;

public class Main {
    public static void main(String[] args) {
        MutableString name = new MutableString("John");
        Address addr = new Address("New York");

        Person original = new Person(name, addr);
        Person shallowCopy = new Person(original);
        System.out.println(original.hashCode() + " "+ shallowCopy.hashCode());
        //                  2027961269                  1586270964
        Person deepCopy = new Person(original, true);

        System.out.println("original.name hash:      " + System.identityHashCode(original.name));
        System.out.println("shallowCopy.name hash:   " + System.identityHashCode(shallowCopy.name));
        System.out.println("deepCopy.name hash:      " + System.identityHashCode(deepCopy.name));

        System.out.println("\nChanging original.name.value to 'Mike'");
        original.name.value = "Mike";

        System.out.println("original name:      " + original);
        System.out.println("shallowCopy name:   " + shallowCopy);
        System.out.println("deepCopy name:      " + deepCopy);
    }
}
