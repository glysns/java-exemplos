package digytal.java.infra.converter;

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
	boolean isDomainClass(Class clazz){
		return !( clazz.isPrimitive() || clazz.getName().startsWith("java."));
	}
	boolean isCollection(Class c) {
		  return Collection.class.isAssignableFrom(c) || Map.class.isAssignableFrom(c);
	}
}
