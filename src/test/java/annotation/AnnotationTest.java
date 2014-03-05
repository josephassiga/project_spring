package annotation;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

import bean.PersonneDo;

/**
 * @author joseph
 * 
 */
public class AnnotationTest {

	@Test
	public final void testValidatioinPojo() {

		final ValidatorFactory factory = Validation
				.buildDefaultValidatorFactory();
		final Validator validator = factory.getValidator();

		final PersonneDo personneDto = new PersonneDo();
		personneDto.setIdPersonne(1);
		personneDto.setNom("Assiga");
		personneDto.setDateNaissance(new Date());
		final Set<ConstraintViolation<PersonneDo>> constraintViolations = validator
				.validate(personneDto);

		System.out.println(constraintViolations.size());
		if (constraintViolations.size() > 0) {
			System.out.println("Impossible de valider les données du bean");
			for (final ConstraintViolation<PersonneDo> constraintViolation : constraintViolations) {
				System.out.println(constraintViolation.getRootBeanClass()
						.getSimpleName()
						+ "."
						+ constraintViolation.getPropertyPath()
						+ " "
						+ constraintViolation.getMessage());
			}
		} else {
			System.out.println("Les données du bean sont valides");
		}

	}

}
