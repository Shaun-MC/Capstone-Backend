package com.windowbutlers.backend.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StyleRequestValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidStyleRequest {
    String message() default "Invalid style request";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}
