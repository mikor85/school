package com.example.school;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BetweenValidator.class)
@Documented
public @interface Between {
    String message() default "{Id.invalid}";
    Class<?> [] groups() default {};

    Class<? extends Payload> [] payload() default {};

    long from();
    long to();
}