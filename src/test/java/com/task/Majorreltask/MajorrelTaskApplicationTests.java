package com.task.Majorreltask;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MajorrelTaskApplicationTests {
	
	Calculator c=new Calculator();

	@Test
	void contextLoads() {
	}
	
	@Test
	
	void testSum() {
		int actual=c.doSum(5, 6, 7);
		assertThat(actual).isEqualTo(18);
	}
	
	@Test
	void testMult() {
		assertThat(45).isEqualTo(9*5);
	}
	

}
