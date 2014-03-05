package strategies.premiereStrategie;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author joseph
 * 
 *         Dans cette stratégie, qui est celle par défaut, le modèle relationnel
 *         est fait d'une seule table pour toute la hiérarchie de classes. Les 2
 *         types de Personne sont stockés dans une même table. Celle-ci est
 *         constituée de l'ensemble des colonnes de la hiérarchie de classes,
 *         auquel vient s'ajouter une colonne technique appelée discriminant
 *         (nommée TypePersonneEnum par défaut), qui permet à Hibernate de
 *         déterminer le type de Personne et donc la classe à instancier.
 * 
 * */

@Entity
@Table(name = "personne_premiere_strategie")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "personneType", discriminatorType = DiscriminatorType.STRING)
public abstract class PersonnePremiereStrategie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersonne;

	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	private String nom;

	@Column(insertable = false, updatable = false)
	private String personneType;

	public PersonnePremiereStrategie() {
	}

	public PersonnePremiereStrategie(final Date dateNaissance,
			final String nom, final String personneType) {
		this.dateNaissance = dateNaissance;
		this.nom = nom;
		this.personneType = personneType;
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