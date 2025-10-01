package com.example.java_fact_emailer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class JavaFactEmailerApplicationTests {

	@Test
	void contextLoads() {
	}

}
