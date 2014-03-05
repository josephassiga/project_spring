package strategies.secondeStrategie;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author joseph
 * 
 *         Avec cette stratégie de mapping, il y a une table pour chaque classe
 *         concrète : chaque type de Personne est stocké dans sa propre table.
 *         Chaque table reprend les colonnes de la classe mère, grand-mère,
 *         etc... Par contre les classes abstraites comme
 *         PersonneSecondeStrategie ne sont pas représentées.
 * @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS): annotation
 *                       utilisées sur la super-class
 */
@Entity(name = "HommeSecondeStrategie")
@Table(name = "homme_seconde_strategie")
public class HommeSecondeStrategie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersonne;

	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	private String nom;

	public HommeSecondeStrategie(final Date dateNaissance, final String nom) {
		super();
		this.dateNaissance = dateNaissance;
		this.nom = nom;
	}

	public HommeSecondeStrategie() {

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
	public void setIdPersonne(final int idPersonne) {
		this.idPersonne = idPersonne;
	}

	/**
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
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
		return nom;
	}

	/**
	 * @param nom
	 */
	public void setNom(final String nom) {
		this.nom = nom;
	}

}
