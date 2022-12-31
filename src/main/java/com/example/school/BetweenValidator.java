package com.example.school;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BetweenValidator implements ConstraintValidator<Between, Long> {

    private long from = 0;
    private long to = 0;

    @Override
    public void initialize(Between c) {
        from = c.from();
        to = c.to();
    }

    @Override
    public boolean isValid(Long l, ConstraintValidatorContext c) {
        return l != 0 && l >= from && l <= to;
    }
}