package strategies.premiereStrategie;

import java.util.Date;

import javax.persistence.Entity;

/**
 * @author joseph
 * 
 */
@Entity
public class HommePremiereStrategie extends PersonnePremiereStrategie {

	public HommePremiereStrategie(final String nom, final Date date) {
		super(date, nom, "HOMME");
	}

	public HommePremiereStrategie() {

	}

}
