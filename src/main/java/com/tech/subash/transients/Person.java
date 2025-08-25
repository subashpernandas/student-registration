package com.tech.subash.transients;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.*;


@Slf4j
class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private final transient String password;
    private String dept;
    private String age;

    public Person(String name, String password, String dept) {
        this.name = name;
        this.password = password;
        this.dept = dept;
    }

    public void printInfo() {
        log.info("Name {}, Pwd {}, Dept {}", password);
    }
}
