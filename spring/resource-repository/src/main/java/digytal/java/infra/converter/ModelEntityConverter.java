package digytal.java.infra.converter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class ModelEntityConverter extends ModelConveter {
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
				invokeSet(other,field,value);
			}
		}
		return other;
	}
	private Object invokeSet(Object object, Field field,  Object value) throws Exception {
		Class type = field.getType().isPrimitive() && field.getType().getName().equalsIgnoreCase("boolean") ? boolean.class:field.getType();
		Method method = object.getClass().getMethod(method("set",field.getName()),type);
		return method.invoke(object, value);
	}

}
