package com.web.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PracticeApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(PracticeApplicationTests.class);

	@Test
	public void contextLoads() {
	}


	@Test
	public void testMethod(){
		logger.info("info");
		logger.error("hello-error");
	}

}

