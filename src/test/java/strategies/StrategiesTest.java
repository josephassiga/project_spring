package strategies;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import strategies.premiereStrategie.FemmePremiereStrategie;
import strategies.premiereStrategie.HommePremiereStrategie;
import strategies.premiereStrategie.PersonnePremiereStrategie;
import strategies.secondeStrategie.FemmeSecondeStrategie;
import strategies.secondeStrategie.HommeSecondeStrategie;
import strategies.troisiemeStrategie.FemmeStroisiemeStrategie;
import strategies.troisiemeStrategie.HommeStroisiemeStrategie;
import strategies.troisiemeStrategie.PersonneTroisiemeStrategie;
import factory.PathEnum;
import factory.SpringFactory;

@Transactional
public class StrategiesTest {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction transaction;

	@Before
	public final void init() {
		this.entityManagerFactory = SpringFactory
				.getContext(PathEnum.CLASSPATH).getBean("entityManagerFactory",
						EntityManagerFactory.class);
		this.entityManager = this.entityManagerFactory.createEntityManager();
		transaction = this.entityManager.getTransaction();
	}

	@After
	public final void end() {

		this.transaction.commit();
		this.entityManager.close();
		this.entityManagerFactory.close();
	}

	// @Test
	public final void createHommeAndFemmePremiereStrategie() {
		final PersonnePremiereStrategie personne = new HommePremiereStrategie(
				"Patrick", new Date());
		final PersonnePremiereStrategie femme = new FemmePremiereStrategie(
				"Poupette", new Date());

		transaction.begin();
		this.entityManager.persist(personne);
		this.entityManager.persist(femme);

	}

	@Test
	public final void createHommeAndFemmeSecondeStrategie() {
		final HommeSecondeStrategie homme = new HommeSecondeStrategie();
		homme.setIdPersonne(1);
		homme.setNom("Joseph");
		homme.setDateNaissance(new Date());

		final FemmeSecondeStrategie femme = new FemmeSecondeStrategie();
		femme.setIdPersonne(2);
		femme.setNom("Josianne");
		femme.setDateNaissance(new Date());

		transaction.begin();
		transaction.setRollbackOnly();
		this.entityManager.persist(homme);
		this.entityManager.persist(femme);
	}

	@Test
	public final void createHommeAndFemmeTroisiemeStrategie() {
		final PersonneTroisiemeStrategie homme = new HommeStroisiemeStrategie(
				1, "Joseph", new Date());
		final PersonneTroisiemeStrategie femme = new FemmeStroisiemeStrategie(
				2, "Julie", new Date());
		transaction.begin();

		this.entityManager.persist(homme);
		this.entityManager.persist(femme);

	}

}
