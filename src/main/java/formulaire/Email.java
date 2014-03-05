package formulaire;

/**
 * Permet de contenir l'objet pour l'envoie de l'Email.
 * 
 * @author joseph
 * 
 */
public class Email {

	private String from;
	private String to;
	private String subject;
	private String message;

	public Email() {
		super();
	}

	public Email(final String from, final String to, final String subject,
			final String message) {
		super();
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.message = message;
	}

	/**
	 * @return
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from
	 */
	public void setFrom(final String from) {
		this.from = from;
	}

	/**
	 * @return
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to
	 */
	public void setTo(final String to) {
		this.to = to;
	}

	/**
	 * @return
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 */
	public void setSubject(final String subject) {
		this.subject = subject;
	}

	/**
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 */
	public void setMessage(final String message) {
		this.message = message;
	}

}
