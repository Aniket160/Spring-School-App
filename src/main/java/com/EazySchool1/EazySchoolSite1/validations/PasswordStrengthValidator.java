package com.EazySchool1.EazySchoolSite1.validations;

import com.EazySchool1.EazySchoolSite1.annotations.PasswordValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class PasswordStrengthValidator implements
        ConstraintValidator<PasswordValidator,String> {

    List<String> weakPasswords;

    @Override
    public void initialize(PasswordValidator passwordValidator) {
        weakPasswords.add("12345");
        weakPasswords.add("password");
        weakPasswords.add("qwerty");
    }

    @Override
    public boolean isValid(String passwordField,
                           ConstraintValidatorContext cxt) {
        return passwordField != null && (!weakPasswords.contains(passwordField));
    }
}