package com.yurets_y.bean_validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class AccountValidator {

    private Validator validator;

    public AccountValidator() {
        //Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        //It validates bean instances
        this.validator = factory.getValidator();
    }

    public void testEntity(Account account){
        //Validate bean
        Set<ConstraintViolation<Account>> constraintViolations = validator.validate(account);

        //Show errors
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Account> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
        }
    }
}
