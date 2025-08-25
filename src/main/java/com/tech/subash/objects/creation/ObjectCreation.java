package com.tech.subash.objects.creation;

import lombok.Builder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


@Builder
public class ObjectCreation implements Cloneable, Serializable {

    ObjectCreation() {
    }

    ObjectCreation(int a) {
    }

    public static void main(String[] args) throws CloneNotSupportedException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {

        ObjectCreation normalCall = new ObjectCreation(2);

        ObjectCreation obj1 = new ObjectCreation(2);
        ObjectCreation usingClone = (ObjectCreation) obj1.clone();

        //ObjectCreation usingReflection = ObjectCreation.class.newInstance(); // requires public no-arg constructor

        Constructor<ObjectCreation> declaredConstructor = ObjectCreation.class.getDeclaredConstructor(int.class);
        declaredConstructor.setAccessible(true);
        ObjectCreation objectCreation = (ObjectCreation) declaredConstructor.newInstance(2);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.ser"));
        ObjectCreation obj = (ObjectCreation) in.readObject();

        ObjectCreation usingBuilder = ObjectCreation.builder().build();
    }
}
