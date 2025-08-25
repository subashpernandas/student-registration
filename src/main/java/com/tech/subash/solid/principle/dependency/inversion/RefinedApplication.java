package com.tech.subash.solid.principle.dependency.inversion;

public class RefinedApplication {
    
    private final RefinedDataBase refinedDataBase;

    public RefinedApplication(RefinedDataBase refinedDataBase){
        this.refinedDataBase = refinedDataBase;
    }

    public void start(){
        refinedDataBase.connect();
    }

    public static void main(String[] args) {
        RefinedApplication refinedApplication = new RefinedApplication(new RefinedMySqlDataConnection());
        refinedApplication.start();
    }
}
