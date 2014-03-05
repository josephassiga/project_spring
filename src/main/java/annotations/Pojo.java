package annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author joseph
 */
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER,
		ElementType.PACKAGE, ElementType.LOCAL_VARIABLE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckPojoValidator.class)
@Documented
public @interface Pojo {

	// le message à afficher, situé dans le properties
	String message() default "{nom.message.perso}";

	// pour respecter la norme
	Class<?>[] groups() default {};

	// pour respecter la norme
	Class<? extends Payload>[] payload() default {};

	// un attribut de l'annotation
	PojoEnum value() default PojoEnum.POJO;

}
