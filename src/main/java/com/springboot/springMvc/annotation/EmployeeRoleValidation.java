package com.springboot.springMvc.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.apache.logging.log4j.message.StringFormattedMessage;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = {EmployeeRoleValidator.class})
public @interface EmployeeRoleValidation
{

    String message() default "Role of Employee can either be USER or ADMIN";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
