package com.tech.subash.variable;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
Instance Variable
------------------
A variable declared inside a class but outside any method, and not marked static.
Belongs to each object of the class.
Every object has its own copy.
Initialized when the object is created.
Accessed via objectName.variable.

Global Variable
-----------------
Singleton pattern for global state.
Accessible from anywhere if public static.
Often placed in a utility or config class.

Static Variable (Class Variable)
----------------------------------
A variable declared with the static keyword. Belongs to the class, not to instances.
Shared across all objects of the class.
Only one copy exists in memory.
Initialized when the class is loaded.
Accessed via ClassName.variable or via object (not recommended).
 */

//@Data
//@AllArgsConstructor
public class VariableComparison {
    int studentMathsMarks;
    static int studentScienceMarks; // by set as java in default so within the same package
    public static int studentTamilMarks;
    public final int socialScienceMarks;// = 0; // once the variable has been declared as file must be initialized
     {
      socialScienceMarks = 95;
     }

    public static void main(String[] args) {
        VariableComparison variableComparison = new VariableComparison();
        System.out.println(variableComparison.studentMathsMarks);
        System.out.println(VariableComparison.studentScienceMarks); // static variable
        System.out.println(variableComparison.socialScienceMarks); // static variable
    }
}
