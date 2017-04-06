package com.organisation.dealer.beans.custom.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.organisation.dealer.beans.ResetPasswordBeans;

public class PasswordsEqualConstraintValidator implements ConstraintValidator<PasswordsEqualConstraint, Object>{

	@Override
	public void initialize(PasswordsEqualConstraint constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		ResetPasswordBeans beans = (ResetPasswordBeans) value;
		return beans.getPassword().equals(beans.getConfirmPassword());
	}
	
	
}
