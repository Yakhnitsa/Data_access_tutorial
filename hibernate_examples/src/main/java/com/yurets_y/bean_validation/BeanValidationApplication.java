package com.yurets_y.bean_validation;

import org.h2.util.DateTimeUtils;

import java.text.SimpleDateFormat;

public class BeanValidationApplication {
    public static void main(String[] args) throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


        AccountValidator validator = new AccountValidator();
        Account invalidAccount = new Account();

        invalidAccount.setName("Jeff");
        invalidAccount.setEmail("Jeff#johnson.mail.ru");
        invalidAccount.setCreationTime(dateFormat.parse("2020-01-18"));
        invalidAccount.setPassword("2910516");

        validator.testEntity(invalidAccount);

    }
}
