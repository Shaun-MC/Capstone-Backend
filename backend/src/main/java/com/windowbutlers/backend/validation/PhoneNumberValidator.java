package com.windowbutlers.backend.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{3}-\\d{3}-\\d{4}$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && PHONE_PATTERN.matcher(value).matches();
    }
}
