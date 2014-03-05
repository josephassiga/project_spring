package controller;

import java.util.Calendar;
import java.util.GregorianCalendar;

import model.PersonneDto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author joseph
 * 
 */
@Controller
public class JSONController {

	/**
	 * @param name
	 * @return
	 */
	@RequestMapping("/json")
	@ResponseBody
	public PersonneDto index(
			@RequestParam(value = "name", required = false, defaultValue = "joseph") final String name) {
		final PersonneDto personneDO = new PersonneDto();
		personneDO.setNom(name);
		personneDO.setIdPersonne(1);
		personneDO.setDateNaissance(new GregorianCalendar(2014,
				Calendar.FEBRUARY, 18).getTime());
		return personneDO;
	}
}
