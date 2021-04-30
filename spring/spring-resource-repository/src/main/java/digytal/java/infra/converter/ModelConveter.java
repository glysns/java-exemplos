package digytal.java.infra.converter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

public abstract class ModelConveter {
	protected Object src;
	ModelConveter(Object src){
		this.src=src;
	}
	public static synchronized ModelConveter getInstance(Object object) {
		String prefixo = object.getClass().getSimpleName();
		if(prefixo.endsWith("Entity"))
			return  new EntityModelConverter(object);
		else
			return new ModelEntityConverter(object);
	}
	String method(String prefix,String field) {
		return prefix+field.substring(0,1).toUpperCase() + field.substring(1,field.length());
	}
	public abstract <E> E newInstance() throws Exception;
	abstract Object converter(Object other) throws Exception;
	
	boolean isDomainClass(Object o){
		Class c = o.getClass();
		return !( c.isPrimitive() || c.getName().startsWith("java."));
	}
	boolean isCollection(Object o) {
		  Class c = o.getClass();
		  return Collection.class.isAssignableFrom(c) || Map.class.isAssignableFrom(c);
	}
	boolean isItem(Object o) {
		  Class c = o.getClass();
		  return isCollection(o) && isDomainClass(o);
	}
	Object add(Object list, Object item) throws Exception {
		Method m = list.getClass().getDeclaredMethod("add",Object.class);
		return m.invoke(list, item);
	}
	<E> E get(Field field, Object object) throws Exception {
		String prefix = field.getType().equals(boolean.class)?"is":"get";		
		Method method = object.getClass().getMethod(method(prefix,field.getName()));
		return (E) method.invoke(object);
	}
	Object set(Object object,String name, Object value) throws Exception {
		//Class type = field.getType().isPrimitive() && field.getType().getName().equalsIgnoreCase("boolean") ? boolean.class:field.getType();
		Class type = value.getClass().getName().equalsIgnoreCase("java.lang.Boolean") ? boolean.class:value.getClass();
		Method method = object.getClass().getMethod(method("set",name),type);
		return method.invoke(object, value);
	}
}
