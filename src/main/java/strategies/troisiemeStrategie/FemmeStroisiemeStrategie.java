package strategies.troisiemeStrategie;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author joseph
 * 
 */
@Entity(name = "FemmeTroisiemeStrategie")
@Table(name = "femme_troisieme_strategie")
public class FemmeStroisiemeStrategie extends PersonneTroisiemeStrategie {

	@Column(insertable = false, updatable = false)
	private int idPersonne;

	public FemmeStroisiemeStrategie(final int idFemme, final String nom,
			final Date dateNaissance) {
		super(dateNaissance, nom);
		this.idPersonne = idFemme;
	}

	public FemmeStroisiemeStrategie() {

	}

	/*
	 * @see
	 * strategies.troisiemeStrategie.PersonneTroisiemeStrategie#getIdPersonne()
	 */
	public int getIdPersonne() {
		return idPersonne;
	}

	/*
	 * @see
	 * strategies.troisiemeStrategie.PersonneTroisiemeStrategie#setIdPersonne
	 * (int)
	 */
	public void setIdPersonne(final int idPersonne) {
		this.idPersonne = idPersonne;
	}

}
