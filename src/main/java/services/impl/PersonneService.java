package services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.PersonneDto;

import org.hibernate.PersistentObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.IPersonneService;
import bean.PersonneDo;
import dao.IPersonneDao;

/**
 * @author joseph
 * 
 */
@Service
@Transactional
public class PersonneService implements IPersonneService {

	@Autowired
	private IPersonneDao personneDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see services.IPersonneService#createPersonne(model.PersonneDto)
	 */
	@Override
	public void createPersonne(final PersonneDto personneDto) {

		if (!this.verifyUnicityOfId(personneDto)) {
			this.personneDao.createPersonne(this
					.convertModelToBean(personneDto));
		} else {
			throw new PersistentObjectException(
					"Votre Object Existe déjà en Base avec l'identifiant  :"
							+ personneDto.getIdPersonne());
		}

	}

	@Override
	public void deletePersonne(final PersonneDto personneDto) {

		this.personneDao.deletePersonne(this.convertModelToBean(personneDto));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see services.IPersonneService#deleterPersonneById(java.lang.Integer)
	 */
	@Override
	public void deleterPersonneById(final Integer idPersonne) {

		this.personneDao.deleterPersonneById(idPersonne);
	}

	@Override
	public void updatePersonne(final Integer idPersonne,
			final PersonneDto personneDto) {
		this.personneDao.updatePersonne(idPersonne,
				this.convertModelToBean(personneDto));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see services.IPersonneService#addFriendsToPersonne(model.PersonneDto,
	 * model.PersonneDto)
	 */
	@Override
	public void addFriendsToPersonne(final PersonneDto personneDto,
			final PersonneDto friendPersonneDto) {

		final PersonneDo personneDo = this.convertModelToBean(personneDto);
		final PersonneDo friendPersonneDo = this
				.convertModelToBean(friendPersonneDto);

		this.personneDao.addFriendsToPersonne(personneDo, friendPersonneDo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see services.IPersonneService#findPersonneById(java.lang.Integer)
	 */
	@Override
	public PersonneDto findPersonneById(final Integer idPersonne) {
		return this.convertBeanToModel(this.personneDao
				.findPersonneById(idPersonne));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see services.IPersonneService#findAllPersonne()
	 */
	@Override
	public List<PersonneDto> findAllPersonne() {
		final List<PersonneDto> personneDOs = new ArrayList<PersonneDto>();

		for (PersonneDo personne : this.personneDao.findAllPersonne()) {
			personneDOs.add(this.convertBeanToModel(personne));
		}

		return personneDOs;
	}

	/**
	 * Permet de convertir un model PersonneDO en un Bean Personne
	 * 
	 * @param personneDO
	 * @return
	 */
	private PersonneDo convertModelToBean(final PersonneDto personneDto) {
		final PersonneDo personne = new PersonneDo();

		personne.setIdPersonne(personneDto.getIdPersonne());
		personne.setNom(personneDto.getNom());
		personne.setDateNaissance(personneDto.getDateNaissance());

		return personne;
	}

	/**
	 * Permet de convertir un model Personne en un Bean PersonneDo
	 * 
	 * @param personneDO
	 * @return
	 */
	private PersonneDto convertBeanToModel(final PersonneDo personneDo) {
		final PersonneDto personneDto = new PersonneDto();
		personneDto.setIdPersonne(personneDo.getIdPersonne());
		personneDto.setNom(personneDo.getNom());
		personneDto.setDateNaissance(personneDo.getDateNaissance());
		return personneDto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see services.IPersonneService#verifyUnicityOfId(model.PersonneDto)
	 */
	@Override
	public boolean verifyUnicityOfId(final PersonneDto personneDto) {
		final List<PersonneDto> personneDOs = this.findAllPersonne();
		final Set<Integer> idPersonneSet = new HashSet<Integer>();
		for (PersonneDto personne : personneDOs) {
			idPersonneSet.add(personne.getIdPersonne());
		}
		return idPersonneSet.contains(personneDto.getIdPersonne());
	}
}
