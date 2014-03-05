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
 *         concrète : chaque type de véhicule est stocké dans sa propre table.
 *         Chaque table reprend les colonnes de la classe mère, grand-mère,
 *         etc... Par contre les classes abstraites comme
 *         PersonneSecondeStrategie ne sont pas représentées.
 * @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS): annotation
 *                       utilisées sur la super-class
 */

@Entity(name = "FemmeSecondeStrategie")
@Table(name = "femme_seconde_strategie")
public class FemmeSecondeStrategie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersonne;

	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	private String nom;

	public FemmeSecondeStrategie(final Date dateNaissance, final String nom) {
		super();
		this.dateNaissance = dateNaissance;
		this.nom = nom;
	}

	public FemmeSecondeStrategie() {

	}

	public FemmeSecondeStrategie(final int idPersonne, final Date dateNaissance,
			final String nom) {
		super();
		this.idPersonne = idPersonne;
		this.dateNaissance = dateNaissance;
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
