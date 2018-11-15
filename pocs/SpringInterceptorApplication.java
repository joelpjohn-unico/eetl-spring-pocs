package org.sonusoft;

import org.sonusoft.interceptors.SessionTimeoutInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringInterceptorApplication implements WebMvcConfigurer {
	
	@Autowired
	SessionTimeoutInterceptor sti;

	public static void main(String[] args) {
		SpringApplication.run(SpringInterceptorApplication.class, args);
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(sti);
	}
}
