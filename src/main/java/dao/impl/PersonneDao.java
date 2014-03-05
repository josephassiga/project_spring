package dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.AmiDo;
import bean.PersonneDo;
import dao.IPersonneDao;

/**
 * @author joseph
 */
@Repository
@Transactional("transactionManager")
public class PersonneDao implements IPersonneDao {

	@PersistenceContext(unitName = "JPA_UNIT")
	private EntityManager entityManager;

	/*
	 * @see dao.IPersonneDAO#createPersonne(bean.PersonneDo)
	 */
	@Override
	public void createPersonne(final PersonneDo personneDo) {

		this.entityManager.persist(personneDo);
	}

	/*
	 * @see dao.IPersonneDAO#deletePersonne(bean.PersonneDo)
	 */
	@Override
	public void deletePersonne(final PersonneDo personneDo) {

		this.entityManager.remove(personneDo);
	}

	/*
	 * @see dao.IPersonneDAO#deleterPersonneById(java.lang.Integer)
	 */
	@Override
	public void deleterPersonneById(final Integer idPersonne) {

		final PersonneDo personneDo = this.entityManager.find(PersonneDo.class,
				idPersonne);
		if (personneDo != null) {
			this.deletePersonne(personneDo);
		}
	}

	/*
	 * @see dao.IPersonneDAO#updatePersonne(java.lang.Integer, bean.PersonneDo)
	 */
	@Override
	public void updatePersonne(final Integer idPersonne,
			final PersonneDo personneDo) {
		final PersonneDo personneDoUpdate = this.entityManager.find(
				PersonneDo.class, idPersonne);
		if (personneDoUpdate != null) {
			personneDoUpdate.setNom(personneDo.getNom());
			personneDoUpdate.setIdPersonne(personneDo.getIdPersonne());
			personneDoUpdate.setDateNaissance(personneDo.getDateNaissance());
			this.entityManager.merge(personneDoUpdate);
		}
	}

	/*
	 * @see dao.IPersonneDAO#findAllPersonne()
	 */
	@Override
	public List<PersonneDo> findAllPersonne() {
		@SuppressWarnings("unchecked")
		final List<PersonneDo> personneDos = (List<PersonneDo>) this.entityManager
				.createNamedQuery("PersonneDo.findAll").getResultList();

		return personneDos;
	}

	/*
	 * @see dao.IPersonneDAO#findFriendsOfPersonneById(java.lang.Integer)
	 */
	@Override
	public List<PersonneDo> findFriendsOfPersonneById(final Integer idPersonne) {

		final PersonneDo personneDo = this.entityManager.find(PersonneDo.class,
				idPersonne);
		final List<PersonneDo> personneDos = new ArrayList<PersonneDo>();

		for (final AmiDo amiDo : personneDo.getAmis()) {
			final PersonneDo personneDo2 = this.entityManager.find(
					PersonneDo.class, amiDo.getIdFriend());
			personneDos.add(personneDo2);
		}

		return personneDos;
	}

	/*
	 * @see dao.IPersonneDAO#findFriendOfPersonne(bean.PersonneDo)
	 */
	@Override
	public List<PersonneDo> findFriendOfPersonne(final PersonneDo personneDo) {
		return this.findFriendsOfPersonneById(personneDo.getIdPersonne());
	}

	/*
	 * @see dao.IPersonneDAO#addFriendsToPersonne(bean.PersonneDo,
	 * bean.PersonneDo)
	 */
	@Override
	public void addFriendsToPersonne(final PersonneDo personneDo,
			final PersonneDo friendPersonneDo) {
		final AmiDo amiDo = new AmiDo();
		amiDo.setIdFriend(friendPersonneDo.getIdPersonne());
		amiDo.setPersonne(personneDo);
		this.entityManager.merge(amiDo);

	}

	/*
	 * @see dao.IPersonneDAO#findPersonneById(java.lang.Integer)
	 */
	@Override
	public PersonneDo findPersonneById(final Integer idPersonne) {
		final PersonneDo personneDo = this.entityManager.find(PersonneDo.class,
				idPersonne);
		return personneDo;
	}

}
