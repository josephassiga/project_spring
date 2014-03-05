package bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import annotations.Pojo;

/**
 * The persistent class for the personne database table.
 * 
 */
@Pojo
@Entity
@Table(name = "personne")
@NamedQuery(name = "PersonneDo.findAll", query = "SELECT p FROM PersonneDo p")
public class PersonneDo {

	@Id
	private int idPersonne;

	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	private String nom;

	@OneToMany(mappedBy = "personne", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<AmiDo> amis;

	public PersonneDo() {
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

	public List<AmiDo> getAmis() {
		return this.amis;
	}

	public void setAmis(final List<AmiDo> amis) {
		this.amis = amis;
	}

}