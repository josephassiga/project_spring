package validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import formulaire.FormulaireBean;

/**
 * @author joseph
 * 
 */
@Component
public class FormulaireValidator implements Validator {

	/*
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(final Class<?> clazz) {

		return FormulaireBean.class.equals(clazz);
	}

	/*
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	@Override
	public void validate(final Object target, final Errors errors) {

		final FormulaireBean formulaireBean = (FormulaireBean) target;

		final String nomPersone = formulaireBean.getPersonneDto().getNom();

		if ((nomPersone.isEmpty()) && (nomPersone.length() == 0)) {
			ValidationUtils.rejectIfEmpty(errors, "personneDto.nom",
					"personneDto.nom.empty");
		}

	}

}
