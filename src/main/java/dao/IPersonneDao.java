package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import bean.PersonneDo;

/**
 * @author joseph
 */

@Repository
public interface IPersonneDao {

	/**
	 * Crèe une Personne connaissant l'objet personneDo
	 * 
	 * @param personneDo
	 */
	void createPersonne(final PersonneDo personneDo);

	/**
	 * Supprime une personne connaissant l'objet
	 * 
	 * @param personneDo
	 */
	void deletePersonne(final PersonneDo personneDo);

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
	 * @param personne
	 */
	void updatePersonne(final Integer idPersonne, final PersonneDo personne);

	/**
	 * Recupère la liste des personnes présents en base.
	 * 
	 * @return
	 */
	List<PersonneDo> findAllPersonne();

	/**
	 * Permet de rechercher la liste des amis d'une Personne connaissant son de
	 * idPersonne
	 * 
	 * @param idPersonne
	 * @return
	 */
	List<PersonneDo> findFriendsOfPersonneById(final Integer idPersonne);

	/**
	 * Permet de rechercher la liste des amis d'une personne connaissant
	 * l'object.
	 * 
	 * @param personneDo
	 * @return
	 */
	List<PersonneDo> findFriendOfPersonne(final PersonneDo personneDo);

	/**
	 * Permet d'ajouter un ami de friendPersonneDo à une personne de personneDo.
	 * 
	 * @param personneDo
	 * @param friendPersonneDo
	 */
	void addFriendsToPersonne(final PersonneDo personneDo,
			final PersonneDo friendPersonneDo);

	/**
	 * Recherche une personne en fonction de son identifiant.
	 * 
	 * @param idPersonne
	 * @return
	 */
	PersonneDo findPersonneById(final Integer idPersonne);
}
