package com.tech.subash.service;

import com.tech.subash.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DemoRunnerForTrans implements CommandLineRunner {

    private final ServiceA serviceA;
    private final LogRepository repo;


    @Override
    public void run(String... args) {
        runTest("REQUIRED", () -> {
            try {
                serviceA.outerWithRequired();
            } catch (Exception ignored) {
            }
        });

        runTest("REQUIRES_NEW fail inside", () -> {
            try {
                serviceA.outerWithRequiresNew();
            } catch (Exception ignored) {
            }
        });

        /*runTest("NESTED", () -> {
            try {
                serviceA.outerWithNested();
            } catch (Exception ignored) {
            }
        });

       /* runTest("REQUIRES_NEW fail inside", () -> {
            try {
                serviceA.outerWithRequiresNewFailInside();
            } catch (Exception ignored) {
            }
        });*/
    }

    private void runTest(String label, Runnable test) {
        repo.deleteAll();
        test.run();
        System.out.println(label + " → Rows in DB: " + repo.findAll().size());
        repo.findAll().forEach(e -> System.out.println("  " + e.getMessage()));
        System.out.println("----");
    }
}
