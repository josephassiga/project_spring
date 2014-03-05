package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author joseph
 * 
 */
@Controller
public class StrategieController {

	/**
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "strategie")
	public String index() {
		return "strategie";
	}
}
