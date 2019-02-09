package com.ros.employees.apis;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class ApplicationServiceConfig extends ResourceConfig{

	public ApplicationServiceConfig() {
		register(EmployeeAccessAPI.class);
	}
}
