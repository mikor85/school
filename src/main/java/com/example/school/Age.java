package com.example.school;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeValidator.class)
@Documented
public @interface Age {
    String message() default "{Age.invalid}";
    Class<?> [] groups() default {};

    Class<? extends Payload> [] payload() default {};
}
