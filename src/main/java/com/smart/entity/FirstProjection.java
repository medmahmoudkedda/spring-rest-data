package com.smart.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Student.class, name = "firstProjection")
public interface FirstProjection {

	Long getId();
	
	String getEmail();
	
	@Value("#{target.firstName}" + " " + "#{target.lastName}")
	String getFullName();
	
	@Value("#{target.subjectsLearning.size()}")
	int getTotalSubjets();
}
