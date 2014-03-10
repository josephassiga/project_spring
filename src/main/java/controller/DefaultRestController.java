package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import model.PersonneDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import services.IPersonneService;

/**
 * @author joseph
 * 
 */
@Controller
@RequestMapping("rest")
public class DefaultRestController {

	@Autowired
	private IPersonneService service;

	private PersonneDto personneDto;

	private static final String FORMAT = "dd/MM/YYY";

	final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT,
			Locale.FRANCE);

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index(final ModelMap model) {
		return "restPersonne";
	}

	/**
	 * Permet de supprimer une personne dans la table dont l'identifiant = id.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public List<PersonneDto> deletePersonne(@PathVariable final int id) {
		this.service.deleterPersonneById(id);
		return service.findAllPersonne();
	}

	/**
	 * Permet d'ajouter une personne dans la table
	 * 
	 * @param id
	 * @param nom
	 * @param date
	 * 
	 * @return
	 */
	@RequestMapping(value = { "{id}/{nom}/{date}" }, method = RequestMethod.POST)
	@ResponseBody
	public List<PersonneDto> createPersonne(@PathVariable final int id,
			@PathVariable final String nom, @PathVariable final String date) {

		personneDto = new PersonneDto();
		personneDto.setIdPersonne(id);
		personneDto.setNom(nom);
		try {
			personneDto.setDateNaissance(simpleDateFormat.parse(date));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		this.service.createPersonne(personneDto);

		return service.findAllPersonne();
	}

	/**
	 * Permet de mettre à jour les informations utilisateurs.
	 * 
	 * @param model
	 * @param id
	 * @param nom
	 * @param date
	 * @return
	 */
	@RequestMapping(value = "{id}/{nom}/{date}", method = RequestMethod.PUT)
	@ResponseBody
	public List<PersonneDto> updatePersonne(@PathVariable final int id,
			@PathVariable final String nom, @PathVariable final String date) {
		personneDto = new PersonneDto();
		personneDto.setIdPersonne(id);
		personneDto.setNom(nom);
		try {
			personneDto.setDateNaissance(simpleDateFormat.parse(date));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		this.service.updatePersonne(id, personneDto);
		return service.findAllPersonne();
	}

	/**
	 * Permet d'obtenir des informations sur une personne connaissant son
	 * identifiant.
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public PersonneDto infoPersonneById(@PathVariable final int id) {
		return service.findPersonneById(id);
	}

}
