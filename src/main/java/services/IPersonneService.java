package services;

import java.util.List;

import model.PersonneDto;

import org.springframework.stereotype.Repository;

/**
 * @author joseph
 * 
 */
@Repository
public interface IPersonneService {
	/**
	 * Crèe une Personne connaissant l'objet personneDO
	 * 
	 * @param personneDO
	 */
	void createPersonne(final PersonneDto personneDO);

	/**
	 * Supprime une personne connaissant l'objet
	 * 
	 * @param personneDO
	 */
	void deletePersonne(final PersonneDto personneDO);

	/**
	 * Supprime une personne connaissant son Id
	 * 
	 * @param idPersonne
	 */
	void deleterPersonneById(final Integer idPersonne);

	/**
	 * Met à jour les informations d'une personne de idPersonne avec l'objet
	 * personneDO
	 * 
	 * @param idPersonne
	 * @param personneDO
	 */
	void updatePersonne(final Integer idPersonne, final PersonneDto personneDO);

	/**
	 * Permet d'ajouter un ami de friendPersonneDto à une personne de
	 * personneDto.
	 * 
	 * @param personneDto
	 * @param friendPersonneDto
	 */
	void addFriendsToPersonne(final PersonneDto personneDto,
			final PersonneDto friendPersonneDto);

	/**
	 * Recherche une personne en fonction de son identifiant.
	 * 
	 * @param idPersonne
	 * @return
	 */
	PersonneDto findPersonneById(final Integer idPersonne);

	/**
	 * Recupère la liste des personnes présents en base.
	 * 
	 * @return
	 */
	List<PersonneDto> findAllPersonne();

	/**
	 * Permet de vérifier que l'identifiant de la personne est unique.
	 * 
	 * @param personneDO
	 * @return
	 */
	boolean verifyUnicityOfId(final PersonneDto personneDO);
}
