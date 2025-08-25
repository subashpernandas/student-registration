package com.tech.subash.solid.principle.dependency.inversion;

public class DependencyInversionAccess {
    public static void main(String[] args) {
        RefinedApplication refinedDataBase = new RefinedApplication(new RefinedMySqlDataConnection());
        refinedDataBase.start();
    }
}
