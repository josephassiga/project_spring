package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * @author joseph
 * 
 */
@Component
public class PersonneDto {

	@Min(1)
	private int idPersonne;

	@DateTimeFormat(pattern = "dd/MM/YYYY")
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date dateNaissance;

	@NotBlank
	private String nom;

	private List<AmiDto> amis;

	public PersonneDto() {
	}

	public int getIdPersonne() {
		return this.idPersonne;
	}

	public void setIdPersonne(final int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(final Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(final String nom) {
		this.nom = nom;
	}

	public List<AmiDto> getAmis() {
		return this.amis;
	}

	public void setAmis(final List<AmiDto> amis) {
		this.amis = amis;
	}

	public AmiDto addAmi(final AmiDto ami) {
		getAmis().add(ami);
		ami.setPersonne(this);
		return ami;
	}

	public AmiDto removeAmi(final AmiDto ami) {
		getAmis().remove(ami);
		ami.setPersonne(null);
		return ami;
	}

}