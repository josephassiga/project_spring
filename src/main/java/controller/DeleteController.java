package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import services.IPersonneService;
import validator.FormulaireValidator;
import formulaire.FormulaireBean;

/**
 * @author joseph
 * 
 */
@Controller
@RequestMapping("deletePersonne")
public class DeleteController {

	@Autowired
	private IPersonneService service;

	@Autowired
	private FormulaireValidator formulaireValidator;

	private static final String FORMAT = "dd/MM/YYY";

	protected static Logger logger = Logger.getLogger("DeleteController");

	/**
	 * @param binder
	 */
	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT);
		dateFormat.setLenient(false);

		/**
		 * true passed to CustomDateEditor constructor means convert empty
		 * String to null
		 */
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	/**
	 * @param formulaireBean
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String delete(
			@ModelAttribute("formulaireBean") @Valid final FormulaireBean formulaireBean,
			final BindingResult result, final ModelMap model) {
		logger.info("[=== Entrer dans la fonction delete() ===]");

		formulaireValidator.validate(formulaireBean, result);

		if (result.hasErrors()) {
			return "personne";
		}
		this.service.deleterPersonneById(formulaireBean.getPersonneDto()
				.getIdPersonne());

		logger.info("[=== Entrer dans la fonction delete() ===]");

		model.addAttribute("formulaireBean", new FormulaireBean());
		model.addAttribute("personnes", service.findAllPersonne());
		return "personne";
	}

}
