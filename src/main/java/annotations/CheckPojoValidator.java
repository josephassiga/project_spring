package annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author joseph
 * 
 */
public class CheckPojoValidator implements ConstraintValidator<Pojo, Object> {

	private PojoEnum pojoEnum;
	private static final String GET = "get";
	private static final String SET = "set";
	private static final String DO = "Do";
	private static final String DTO = "Dto";
	private static final String IS = "is";
	private static final String BOOLEAN_TYPE = "boolean";
	private static final String ENTITY = "Entity";

	@Override
	public void initialize(final Pojo constraintAnnotation) {
		this.pojoEnum = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(final Object object,
			final ConstraintValidatorContext context) {

		if (object == null) {
			return false;

		}

		if (this.pojoEnum == PojoEnum.POJO) {
			return this.verifyPojoPackage(object)
					&& this.verifyPojoOptions(object)
					&& this.verifyPojoClassName(object)
					&& this.verifyAttributeModificator(object)
					&& this.verifyPojoMethodeTraitement(object)
					&& this.verifyAttributGettersAndSetters(object);
		}

		return false;
	}

	/**
	 * Permet de vérifier si les attributs sont privés. getFields() retourne un
	 * tableau de tous les chaps publics.
	 * 
	 * @param object
	 * @return
	 */
	private boolean verifyAttributeModificator(final Object object) {

		final Field[] fields = object.getClass().getDeclaredFields();

		for (final Field field : fields) {

			final int fieldModifier = field.getModifiers();

			// Vérifie si on a une variable qui n'est pas private .
			if (!Modifier.isPrivate(fieldModifier)) {
				return false;
			}

		}
		return true;
	}

	/**
	 * Permet de vérifier si les attributs ont des getters/setters en public
	 * 
	 * @param object
	 * @return
	 */
	private boolean verifyAttributGettersAndSetters(final Object object) {
		final List<String> methodes = getListeMethodes(object.getClass()
				.getDeclaredMethods());
		final Field[] fields = object.getClass().getDeclaredFields();

		for (final Field field : fields) {
			final String fieldName = field.getName();
			if ((!findAttributeGetter(fieldName, methodes))
					|| (!findAttributeSetter(fieldName, methodes))) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Permet d'avoir toutes les methodes déclarées dans le POJO
	 * 
	 * @param methods
	 * @return
	 */
	private List<String> getListeMethodes(final Method[] methods) {
		final List<String> listeMethodes = new ArrayList<String>();

		for (final Method method : methods) {
			listeMethodes.add(method.getName());
		}
		return listeMethodes;
	}

	/**
	 * Permet de savoir un attribut a bien un setteurs.
	 * 
	 * @param attributeName
	 * @param methodes
	 * @return
	 */
	private boolean findAttributeSetter(final String attributeName,
			final List<String> methodes) {

		final String nameAttributeSetter = SET
				+ UpperCaseFisrtLetter(attributeName);

		return methodes.contains(nameAttributeSetter);
	}

	/**
	 * Permet de savoir si un attribut a bien un getters.
	 * 
	 * @param attributeName
	 * @param methodes
	 * @return
	 */
	private boolean findAttributeGetter(final String attributeName,
			final List<String> methodes) {

		final String nameAttributeGetter = GET
				+ UpperCaseFisrtLetter(attributeName);

		if (!methodes.contains(nameAttributeGetter)) {
			return this.findIsAttribute(attributeName, methodes);
		}
		return true;
	}

	/**
	 * Permet de savoir un attribut de type boolean commence par
	 * IsAttributTypeBoolean.
	 * 
	 * @param attributeName
	 * @param methodes
	 * @return
	 */
	private boolean findIsAttribute(final String attributeName,
			final List<String> methodes) {

		final String nameAttributeGetter = IS
				+ UpperCaseFisrtLetter(attributeName);

		return methodes.contains(nameAttributeGetter);
	}

	/**
	 * Permet d'avoir toutes les méthodes autorisées dans un POJO.
	 * 
	 * @param object
	 * @return
	 */
	private Set<String> methodesAutorisees(final Object object) {

		final Set<String> methodes = new HashSet<String>();

		for (final Field field : object.getClass().getDeclaredFields()) {
			final String fieldType = field.getType().getSimpleName();
			if (fieldType.equalsIgnoreCase(BOOLEAN_TYPE)) {
				methodes.add(IS + UpperCaseFisrtLetter(field.getName()));
			} else {
				methodes.add(GET + UpperCaseFisrtLetter(field.getName()));
			}
			methodes.add(SET + UpperCaseFisrtLetter(field.getName()));
		}

		for (final Method method : object.getClass().getSuperclass()
				.getDeclaredMethods()) {
			methodes.add(method.getName());
		}

		return methodes;
	}

	/**
	 * Permet de mettre le premier caractère de nameAttribute en majuscule.
	 * 
	 * @param nameAttribute
	 * @return
	 */
	private String UpperCaseFisrtLetter(final String nameAttribute) {
		return nameAttribute.substring(0, 1).toUpperCase()
				+ nameAttribute.substring(1);
	}

	/**
	 * Permet de savoir si une le nom de la classe du POJO est suffixé par DO pu
	 * Dto.
	 * 
	 * @param object
	 * @return
	 */
	private boolean verifyPojoClassName(final Object object) {
		final String className = object.getClass().getSimpleName();
		if (className.endsWith(DO) || className.endsWith(DTO)) {
			return true;
		}
		return false;
	}

	/**
	 * Permet de vérifier que le package du POJO est en minuscule.
	 * 
	 * @param object
	 * @return
	 */
	private boolean verifyPojoPackage(final Object object) {
		final String packageName = object.getClass().getPackage().getName();

		return packageName.toLowerCase().equals(packageName);
	}

	/**
	 * Permet de vérifier si les constances sont en public static
	 * 
	 * @param object
	 * @return
	 */
	private boolean verifyPojoConstantAttribute(final Object object) {
		final Field[] fields = object.getClass().getDeclaredFields();

		for (final Field field : fields) {

			final int fieldModifier = field.getModifiers();

			if ((Modifier.isPublic(fieldModifier))
					&& (!Modifier.isStatic(fieldModifier))) {
				return false;
			}

		}

		return true;
	}

	/**
	 * Permet de vérifier les options : Entity et public static
	 * 
	 * @param object
	 * @return
	 */
	private boolean verifyPojoOptions(final Object object) {
		final Annotation[] annotations = object.getClass().getAnnotations();
		final List<String> listeAnnotations = new ArrayList<String>();

		if (!object.getClass().getSimpleName().endsWith(DO)) {
			return false;
		}

		for (final Annotation annotation : annotations) {
			listeAnnotations.add(annotation.annotationType().getSimpleName());
		}

		return listeAnnotations.contains(ENTITY)
				&& verifyPojoConstantAttribute(object);
	}

	/**
	 * Permet de récupérer la liste des méthodes du POJO.
	 * 
	 * @param object
	 * @return
	 */
	private Set<String> methodesPojo(final Object object) {

		final Method[] methods = object.getClass().getDeclaredMethods();
		final Set<String> methodesPojo = new HashSet<String>();
		for (final Method method : methods) {
			methodesPojo.add(method.getName());
		}

		return methodesPojo;
	}

	/**
	 * Permet de vérifier que le POJO n'a pas de méthodes de traitement.
	 * 
	 * @param object
	 * @return
	 */
	private boolean verifyPojoMethodeTraitement(final Object object) {
		final Set<String> methodesAutorisees = this.methodesAutorisees(object);
		final Set<String> methodesPojo = this.methodesPojo(object);
		methodesPojo.removeAll(methodesAutorisees);

		return methodesPojo.size() == 0 ? true : false;
	}
}
