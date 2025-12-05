package gr.netmechanics.jmix.appcommons.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = Iso639Set1Validator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Iso639Set1 {

    String message() default "{msg://gr.netmechanics.jmix.appcommons.validation/Iso639Set1}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
