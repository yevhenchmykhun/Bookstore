package com.bookstore.web.ui.form.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MultipartFileValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface File {

    String message() default "File is not valid";

    String mediaType() default "";

    long size() default 0;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
