package com.ty.stockadminister.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidation implements ConstraintValidator<PhoneNumber, Long> {

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		Pattern pattern = Pattern.compile("^\\d{10}$");
		Matcher matcher = pattern.matcher(value.toString());
		try {

			if (matcher.matches()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

}