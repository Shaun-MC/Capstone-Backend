package com.windowbutlers.backend.validation;

import com.windowbutlers.backend.dto.StyleRequest;
import com.windowbutlers.backend.enums.StyleLabels;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StyleRequestValidator implements ConstraintValidator<ValidStyleRequest, StyleRequest> {
    
    @Override
    public boolean isValid(StyleRequest value, ConstraintValidatorContext context) {
        if (value.getLabel() == StyleLabels.WINDOWS || value.getLabel() == StyleLabels.TREES) {
            return true; // Allow large/small
        } else {
            return value.getLarge() == null && value.getSmall() == null; // Large/small must be null or not updated
        }
    }
}
