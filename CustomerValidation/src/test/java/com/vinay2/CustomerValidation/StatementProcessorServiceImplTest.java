package com.vinay2.CustomerValidation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.annotation.Configuration;



@RunWith(MockitoJUnitRunner.class)
@Configuration

public class StatementProcessorServiceImplTest {
	
	@InjectMocks
	StatementProcessorServiceImpl statementProcessorServiceImpl;
	@Mock 
	ClassLoader classLoader;

	@Test
	public void test_csv_valid_report() throws Exception {
	
		List<Record> successTranaction =statementProcessorServiceImpl.getCsvReportDetails();
		assertNotNull(successTranaction);
		assertEquals(10,successTranaction.size());
	}

	
	
	
	
}
