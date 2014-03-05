package formulaire;

import javax.validation.Valid;

import model.PersonneDto;

import org.springframework.stereotype.Component;

/**
 * @author joseph
 * 
 */
@Component
public class FormulaireBean {

	@Valid
	private PersonneDto personneDto;

	private PersonneDto friendDto;

	public FormulaireBean() {
		super();
	}

	/**
	 * @return
	 */
	public PersonneDto getPersonneDto() {
		return personneDto;
	}

	/**
	 * @param personneDto
	 */
	public void setPersonneDto(final PersonneDto personneDto) {
		this.personneDto = personneDto;
	}

	/**
	 * @return
	 */
	public PersonneDto getFriendDto() {
		return friendDto;
	}

	/**
	 * @param friendDto
	 */
	public void setFriendDto(final PersonneDto friendDto) {
		this.friendDto = friendDto;
	}

}
