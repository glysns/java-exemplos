package digytal.java.infra.converter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

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
				if(isCollection(value)) {
					set(other,field.getName(),value);
				}else if(isDomainClass(value)) {
					value = getInstance(value).newInstance();
					set(other,field.getName(),value);
				}else if(isItem(value)) {
					List list = get(field, other);
					for(Object i: (List) value) {
						Object n = getInstance(i).newInstance();
						add(list,n);
					}
				}else {
					set(other,field.getName(),value);
				}
				
			}
		}
		return other;
	}
	

}
