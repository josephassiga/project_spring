package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import formulaire.XMLBean;

/**
 * @author joseph
 * 
 */
@Controller
public class XMLController {

	private static final String FORMAT = "dd/MM/YYYY";

	/**
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "xml")
	@ResponseBody
	public XMLBean index(
			@RequestParam(value = "name", required = false, defaultValue = "joseph") final String name) {
		final Date date = new Date();
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT,
				Locale.FRANCE);
		final XMLBean bean = new XMLBean();
		bean.setIdPersonne(1);
		bean.setNom(name);
		try {
			bean.setDateNaissance(simpleDateFormat.parse(simpleDateFormat
					.format(date)));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		return bean;
	}
}
