package de.alpharogroup.scheduler.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import de.alpharogroup.scheduler.system.service.api.AppointmentsService;

@ContextConfiguration(locations = "classpath:test-em-applicationContext.xml")
public class AppointmentsBusinessServiceTest {
	
	@Autowired
	private AppointmentsService appointmentsService;

	@Test(enabled=true)
	public void test() {
		
	}

}
