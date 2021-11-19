package com.mastery.java.task.annotation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class AdultValidator implements ConstraintValidator<Adult, Date> {

    @Override
    public void initialize(Adult constraintAnnotation) {
    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        LocalDate inputDate = LocalDate.parse(value.toString());
        Period period = Period.between(inputDate, LocalDate.now());
        return period.getYears() >= 18;
    }
}
