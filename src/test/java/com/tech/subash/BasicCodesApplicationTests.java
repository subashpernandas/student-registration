package com.tech.subash;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@ActiveProfiles("test")
//@Sql(scripts = "/data.sql")
class BasicCodesApplicationTests {

	@Test
	void contextLoads() {
	}

}
