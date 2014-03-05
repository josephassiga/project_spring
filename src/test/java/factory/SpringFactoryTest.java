package factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

public class SpringFactoryTest {

	@Test
	public final void testBuildSpringFactory() {
		assertNotNull(SpringFactory.getContext(PathEnum.CLASSPATH));
	}

	@Test
	public final void testDataSourceConnection() {
		final BasicDataSource basicDataSource = SpringFactory.getContext(
				PathEnum.CLASSPATH)
				.getBean("dataSource", BasicDataSource.class);
		assertNotNull(basicDataSource);
		assertEquals("jdbc:mysql://localhost:3306/personne",
				basicDataSource.getUrl());

	}

	@Test
	public final void testEntityManagerFactory() {

		final EntityManagerFactory emf = SpringFactory.getContext(
				PathEnum.CLASSPATH).getBean("entityManagerFactory",
				EntityManagerFactory.class);
		assertNotNull(emf);
		assertEquals("org.hibernate.dialect.MySQL5InnoDBDialect", emf
				.getProperties().get("hibernate.dialect"));

		// final Query query = emf.createEntityManager().createQuery(
		// "FROM PersonneDO");
		// assertNotNull(query.getMaxResults());

	}
}
