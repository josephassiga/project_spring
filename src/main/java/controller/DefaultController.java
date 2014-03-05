package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import services.IPersonneService;
import formulaire.FormulaireBean;

/**
 * @author joseph
 * 
 */
@Controller
@RequestMapping("formPersonne")
public class DefaultController {

	@Autowired
	private IPersonneService service;

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String index(final ModelMap model) {
		final FormulaireBean formulaireBean = new FormulaireBean();
		model.addAttribute("formulaireBean", formulaireBean);
		model.addAttribute("personnes", service.findAllPersonne());
		return "personne";
	}

}
