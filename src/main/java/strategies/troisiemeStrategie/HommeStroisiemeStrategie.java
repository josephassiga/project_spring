package strategies.troisiemeStrategie;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
@Entity(name = "HommeTroiemeStrategie")
@Table(name = "homme_troisieme_strategie")
public class HommeStroisiemeStrategie extends PersonneTroisiemeStrategie {

	@Column(insertable = false, updatable = false)
	private int idPersonne;

	public HommeStroisiemeStrategie(final int idHomme, final String nom,
			final Date dateNaissance) {
		super(dateNaissance, nom);
		this.idPersonne = idHomme;
	}

	public HommeStroisiemeStrategie() {

	}

	/*
	 * @see
	 * strategies.troisiemeStrategie.PersonneTroisiemeStrategie#getIdPersonne()
	 */
	public int getIdPersonne() {
		return idPersonne;
	}

	/*
	 * 
	 * @see
	 * strategies.troisiemeStrategie.PersonneTroisiemeStrategie#setIdPersonne
	 * (int)
	 */
	public void setIdPersonne(final int idPersonne) {
		this.idPersonne = idPersonne;
	}

}
