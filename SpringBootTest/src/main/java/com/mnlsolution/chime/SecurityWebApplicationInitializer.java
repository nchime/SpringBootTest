package com.mnlsolution.chime;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer{
	
	
	public SecurityWebApplicationInitializer() {
		super(SecurityConfig.class);   
	}
	
	

}
