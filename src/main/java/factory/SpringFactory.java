package factory;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author joseph
 * 
 */
public final class SpringFactory {

	private static ApplicationContext applicationContext;
	private static final String APPLICATION_CONTEXT_XML = "classpath::applicationContext.xml";
	private static final Logger LOGGER = Logger.getLogger(SpringFactory.class);

	/**
	 * Pour interdire de créer une instance de cette classe.
	 */
	private SpringFactory() {

	}

	/**
	 * @param context
	 * @return
	 */
	public static ApplicationContext getContext(final PathEnum context) {

		if (applicationContext == null) {
			if (PathEnum.CLASSPATH.equals(context)) {
				applicationContext = new ClassPathXmlApplicationContext(
						APPLICATION_CONTEXT_XML);
			} else if (PathEnum.FILE_SYSTEM.equals(context)) {
				applicationContext = new FileSystemXmlApplicationContext(
						APPLICATION_CONTEXT_XML);
			} else {
				LOGGER.debug("Localisation non définie");
			}

		}

		return applicationContext;
	}

}
