package com.windowbutlers.backend.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class UUIDValidator implements ConstraintValidator<ValidUUID, String> {

    // Define the regex pattern for a valid UUID (canonical format)
    private static final Pattern UUID_REGEX_PATTERN = Pattern.compile(
        "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$"
    );

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false; // Or true, depending on whether null is acceptable
        return UUID_REGEX_PATTERN.matcher(value).matches();
    }
}
