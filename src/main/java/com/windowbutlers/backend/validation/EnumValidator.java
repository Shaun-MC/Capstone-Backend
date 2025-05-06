package com.windowbutlers.backend.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.stream.Collectors;
import java.util.Arrays;

public class EnumValidator implements ConstraintValidator<ValidEnum, String> {

    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(ValidEnum constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        boolean isValidString = Arrays.stream(enumClass.getEnumConstants()).anyMatch(e -> e.name().equalsIgnoreCase(value));

        if (!isValidString) {
            // Dynamically build the error message with valid enum values
            String allowedValues = Arrays.stream(enumClass.getEnumConstants()).map(Enum::name).collect(Collectors.joining(", "));

            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(String.format("Value must be one of: %s", allowedValues)).addConstraintViolation();
        }

        return isValidString;
    }
}
