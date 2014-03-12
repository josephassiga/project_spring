package dao;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import model.PersonneDto;

import org.junit.Before;
import org.junit.Test;

import services.IPersonneService;
import factory.PathEnum;
import factory.SpringFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext" })
public class PersonneDaoTest {

        @Autowired
	private IPersonneService iPersonneService;

	public final void testCreatePersonne() {
		final PersonneDto personneDO = new PersonneDto();
		final PersonneDto personneDO2 = new PersonneDto();
		final PersonneDto personneDO3 = new PersonneDto();
		final PersonneDto personneDO4 = new PersonneDto();

		personneDO.setNom("CAMPOS");
		personneDO.setIdPersonne(1);
		personneDO.setDateNaissance(new Date());

		personneDO2.setNom("JOSEPH");
		personneDO2.setIdPersonne(2);
		personneDO2.setDateNaissance(new Date());

		personneDO3.setNom("reine");
		personneDO3.setIdPersonne(3);
		personneDO3.setDateNaissance(new Date());

		personneDO4.setNom("David");
		personneDO4.setIdPersonne(4);
		personneDO4.setDateNaissance(new Date());

		iPersonneService.createPersonne(personneDO);
		iPersonneService.createPersonne(personneDO2);
		iPersonneService.createPersonne(personneDO3);
		iPersonneService.createPersonne(personneDO4);

	}

	public final void testUpdatePersonne() {
		final PersonneDto personneDO = new PersonneDto();
		personneDO.setNom("CARL");
		personneDO.setIdPersonne(2);
		personneDO.setDateNaissance(new Date());

		iPersonneService.updatePersonne(2, personneDO);
	}

	// @Test
	public final void testDeletePersonneById() {

		this.iPersonneService.deleterPersonneById(3);
	}

	public final void testDeletePersonne() {
		final PersonneDto personneDO = new PersonneDto();
		personneDO.setNom("CARL");
		personneDO.setIdPersonne(2);
		personneDO.setDateNaissance(new Date());
		this.iPersonneService.deletePersonne(personneDO);
	}

	public final void testFindAllPersonne() {

		final List<PersonneDto> personnes = this.iPersonneService
				.findAllPersonne();

		for (PersonneDto personne : personnes) {
			System.out.println(personne.getAmis());
		}
		assertNotNull(personnes);
	}

	// @Test
	public final void testAddFriendToPersonne() {
		final PersonneDto personneDO = this.iPersonneService
				.findPersonneById(1);
		final PersonneDto friend = this.iPersonneService.findPersonneById(2);
		final PersonneDto friend2 = this.iPersonneService.findPersonneById(3);
		final PersonneDto friend3 = this.iPersonneService.findPersonneById(4);
		this.iPersonneService.addFriendsToPersonne(friend2, personneDO);
		this.iPersonneService.addFriendsToPersonne(friend2, friend);
		this.iPersonneService.addFriendsToPersonne(friend2, friend3);
		System.out.println(personneDO.getAmis());
	}

	/**
	 * Je considère que l'égalité de deux personne si ils ont le même id.
	 */
	@Test
	public final void testRolBackPersonne() {
		final PersonneDto personneDto = new PersonneDto();
		personneDto.setIdPersonne(9);
		personneDto.setNom("Franck");
		personneDto.setDateNaissance(new Date());
		this.iPersonneService.createPersonne(personneDto);

		final PersonneDto newPersonneDto = new PersonneDto();
		newPersonneDto.setIdPersonne(9);
		newPersonneDto.setNom("Lionel");
		newPersonneDto.setDateNaissance(new Date());

		this.iPersonneService.createPersonne(newPersonneDto);

	}
}
