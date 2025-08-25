package com.tech.subash.design.patterns.template;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class ITDeptRegistration extends StudentRegistration {
    @Override
    String studentRegistration(Student student) {
        return "IT-00"+new Random().nextInt(10);
    }

    @Override
    void isFeesPaid(String id,String studentName ,int deptFee ,boolean isPaid) {
        log.info("Student Name :: {}, Registration Id :: {}, Fee Amount :: {} ,Fees Paid :: {}", studentName, id, deptFee,isPaid);
    }
}
