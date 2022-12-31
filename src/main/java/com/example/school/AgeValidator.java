package com.example.school;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

    @Override
    public boolean isValid(Integer i, ConstraintValidatorContext c) {
        return i != null && i % 2 == 0;
    }
}