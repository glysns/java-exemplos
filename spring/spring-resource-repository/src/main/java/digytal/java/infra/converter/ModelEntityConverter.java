package digytal.java.infra.converter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class ModelEntityConverter extends ModelConveter {
	ModelEntityConverter(Object src) {
		super(src);
		// TODO Auto-generated constructor stub
	}
	public Object newInstance() throws Exception{
		Class srcClass = src.getClass();
		Object other =Class.forName(srcClass.getPackage().getName()+"."+srcClass.getSimpleName()+"Entity").newInstance();
		return converter(other);
	
	}
	@Override
	public Object converter(Object other) throws Exception {
		for(Field field: src.getClass().getDeclaredFields()) {
			Object value= field.get(src);
			if(value!=null) {
				if(isDomainClass(field.getType())) {
					value = getInstance(value).newInstance();
				}
				invokeSet(other,field.getName(),value);
			}
		}
		return other;
	}
	private Object invokeSet(Object object,String name, Object value) throws Exception {
		//Class type = field.getType().isPrimitive() && field.getType().getName().equalsIgnoreCase("boolean") ? boolean.class:field.getType();
		Class type = value.getClass().getName().equalsIgnoreCase("java.lang.Boolean") ? boolean.class:value.getClass();
		Method method = object.getClass().getMethod(method("set",name),type);
		return method.invoke(object, value);
	}

}
