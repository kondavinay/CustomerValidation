package com.vinay2.CustomerValidation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Customer {
	public static void main(String[] args) throws Exception {

		ApplicationContext appcontext = new AnnotationConfigApplicationContext(StatementprocessorConfiguration.class);

		StatementProcessorController controller = appcontext.getBean(StatementProcessorController.class);
		controller.Filereading();

}
}