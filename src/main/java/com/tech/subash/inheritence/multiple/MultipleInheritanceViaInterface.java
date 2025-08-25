package com.tech.subash.inheritence.multiple;

import lombok.extern.slf4j.Slf4j;

interface A {
    void show();
}

interface B {
     void show();
}

@Slf4j
 class MultipleInheritanceViaInterface implements A, B {
    @Override
    public void show() {
       log.info("Resolved in D");
    }
}
