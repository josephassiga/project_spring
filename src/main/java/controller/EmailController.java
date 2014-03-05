package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import formulaire.Email;

/**
 * @author joseph
 * 
 */
@Controller
@RequestMapping("email")
public class EmailController {

	@Autowired
	@Qualifier(value = "senderMail")
	private JavaMailSenderImpl mailSender;

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String index(final ModelMap model) {
		model.addAttribute("email", new Email());
		return "email";
	}

	/**
	 * @param email
	 * @param model
	 * @return
	 */
	@RequestMapping("sendMail")
	public String sendMail(@ModelAttribute final Email email) {

		final SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(email.getFrom());
		message.setTo(email.getTo());
		message.setSubject(email.getSubject());
		message.setText(email.getMessage());
		mailSender.send(message);
		return "redirect:/email";
	}

}
