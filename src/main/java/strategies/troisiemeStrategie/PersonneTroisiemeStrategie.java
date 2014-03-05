package strategies.troisiemeStrategie;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
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
 */

@Entity(name = "personne_troisieme_strategie")
@Table(name = "personne_troisieme_strategie")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "personneType", discriminatorType = DiscriminatorType.STRING)
public abstract class PersonneTroisiemeStrategie {

	@Id
	@Column(insertable = false, updatable = false)
	private int idPersonne;

	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	private String nom;

	public PersonneTroisiemeStrategie() {
	}

	public PersonneTroisiemeStrategie(final Date dateNaissance, final String nom) {
		super();
		this.dateNaissance = dateNaissance;
		this.nom = nom;
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

}