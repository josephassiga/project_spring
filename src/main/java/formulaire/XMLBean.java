package formulaire;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author joseph
 * 
 */
@XmlRootElement(name = "personne")
public class XMLBean {

	private String nom;

	private int idPersonne;

	private Date dateNaissance;

	public XMLBean(final String nom, final int idPersonne,
			final Date dateNaissance) {
		super();
		this.nom = nom;
		this.idPersonne = idPersonne;
		this.dateNaissance = dateNaissance;
	}

	public XMLBean() {
		super();
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 */
	@XmlElement
	public void setNom(final String nom) {
		this.nom = nom;
	}

	/**
	 * @return
	 */
	public int getIdPersonne() {
		return idPersonne;
	}

	/**
	 * @param idPersonne
	 */
	@XmlElement
	public void setIdPersonne(final int idPersonne) {
		this.idPersonne = idPersonne;
	}

	/**
	 * @return
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance
	 */
	@XmlElement
	public void setDateNaissance(final Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

}
