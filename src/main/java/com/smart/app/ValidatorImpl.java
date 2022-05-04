package com.smart.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.smart.entity.Student;


@Configuration
public class ValidatorImpl implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(target instanceof Student) {
			Student student = (Student) target;
			if(student.getFirstName() == null || student.getFirstName().isEmpty()) {
				errors.rejectValue("firstName", "", "First name is required");
			}
		} /*
			 * else if(target instanceof Department) {
			 * 
			 * }
			 */
		
	}

}
