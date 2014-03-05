package model;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

/**
 * @author joseph
 * 
 */
@Component
public class AmiDto {
	@Id
	private int id;

	private int idFriend;

	private PersonneDto personneDto;

	public AmiDto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public int getIdFriend() {
		return this.idFriend;
	}

	public void setIdFriend(final int idFriend) {
		this.idFriend = idFriend;
	}

	public PersonneDto getPersonne() {
		return this.personneDto;
	}

	public void setPersonne(final PersonneDto personneDto) {
		this.personneDto = personneDto;
	}

}