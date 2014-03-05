package strategies.secondeStrategie;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author joseph
 * 
 *         Avec cette stratégie de mapping, il y a une table pour chaque classe
 *         concrète : chaque type de véhicule est stocké dans sa propre table.
 *         Chaque table reprend les colonnes de la classe mère, grand-mère,
 *         etc... Par contre les classes abstraites comme
 *         PersonneSecondeStrategie ne sont pas représentées.
 * @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS): annotation
 *                       utilisées sur la super-class
 */

@Entity(name = "personne_seconde_strategie")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PersonneSecondeStrategie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersonne;

	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	private String nom;

	@Column(insertable = false, updatable = false)
	private String personneType;

	public PersonneSecondeStrategie() {
	}

	public PersonneSecondeStrategie(final Date dateNaissance, final String nom,
			final String personneEnum) {
		super();
		this.dateNaissance = dateNaissance;
		this.nom = nom;
		this.personneType = personneEnum;
	}

	/**
	 * @return
	 */
	public int getIdPersonne() {
		return this.idPersonne;
	}

	/**
	 * @param idPersonne
	 */
	public void setIdPersonne(final int idPersonne) {
		this.idPersonne = idPersonne;
	}

	/**
	 * @return
	 */
	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	/**
	 * @param dateNaissance
	 */
	public void setDateNaissance(final Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * @param nom
	 */
	public void setNom(final String nom) {
		this.nom = nom;
	}

	/**
	 * @return the personneEnum
	 */
	public String getPersonneType() {
		return personneType;
	}

	/**
	 * @param personneType
	 */
	public void setPersonneType(final String personneType) {
		this.personneType = personneType;
	}

}