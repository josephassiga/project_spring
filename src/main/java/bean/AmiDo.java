package bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the amis database table.
 * 
 */
@Entity
@Table(name = "amis")
@NamedQuery(name = "AmiDo.findAll", query = "SELECT a FROM AmiDo a")
public class AmiDo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int idFriend;

	@ManyToOne
	@JoinColumn(name = "idPersonne")
	private PersonneDo personne;

	public AmiDo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public int getIdFriend() {
		return this.idFriend;
	}

	public void setIdFriend(final int idFriend) {
		this.idFriend = idFriend;
	}

	public PersonneDo getPersonne() {
		return this.personne;
	}

	public void setPersonne(final PersonneDo personne) {
		this.personne = personne;
	}

}