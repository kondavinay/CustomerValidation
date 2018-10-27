package com.vinay2.CustomerValidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatementProcessorController {

	@Autowired
	
	StatementProcessorService service;

	public StatementProcessorService getService() {
		return service;
	}

	public void setService(StatementProcessorService service) {
		this.service = service;
	}
	public void Filereading() {
		
		try {
			System.out.println("customerdetails");
			System.out.println(service.getCsvReportDetails());
			System.out.println("failed transcations");
			System.out.print(service.getFailedTransactionDetails());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
