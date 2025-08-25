package com.tech.subash.solid.principle.dependency.inversion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RefinedMySqlDataConnection implements RefinedDataBase {
    @Override
    public void connect() {
      log.info("My Sql connection has been established");
    }
}
