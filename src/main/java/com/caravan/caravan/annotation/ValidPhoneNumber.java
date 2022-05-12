package com.caravan.caravan.annotation;

import com.caravan.caravan.validator.PhoneValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
@Documented
public @interface ValidPhoneNumber {

}
