package strategies.premiereStrategie;

import java.util.Date;

import javax.persistence.Entity;

/**
 * @author joseph
 * 
 */
@Entity
public class FemmePremiereStrategie extends PersonnePremiereStrategie {

	public FemmePremiereStrategie(final String nom, final Date date) {
		super(date, nom, "FEMME");
	}

	public FemmePremiereStrategie() {

	}
}
