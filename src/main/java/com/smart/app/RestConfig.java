package com.smart.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.smart.entity.Student;

@Configuration
public class RestConfig implements RepositoryRestConfigurer{
	
	@Autowired
	private ValidatorImpl validatorImpl;
	
	@Autowired
	private UpdateValidatorImpl updateValidatorImpl;

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		config.exposeIdsFor(Student.class);
	}
	
	@Override
	public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
		validatingListener.addValidator("beforeCreate", validatorImpl);
		validatingListener.addValidator("beforeSave", updateValidatorImpl);
	}
}
