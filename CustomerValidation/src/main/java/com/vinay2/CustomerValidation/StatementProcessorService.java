package com.vinay2.CustomerValidation;

import java.io.IOException;
import java.util.List;



public interface StatementProcessorService {
	
	

	public List<Record> getCsvReportDetails()throws Exception;
	
	public List<Record> getFailedTransactionDetails()throws Exception;
	
	
	
	
}
