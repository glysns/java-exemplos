package digytal.java.infra.converter;

public abstract class ModelConveter {
	private static final ModelConveter MODEL_TO_ENTITY_CONVERTER = new ModelEntityConverter();
	private static final ModelConveter ENTITY_TO_MODEL_CONVERTER = new EntityModelConverter();
	static Object src;
	public static synchronized ModelConveter getInstance(Object object) {
		String prefixo = object.getClass().getSimpleName();
		src=object;
		if(prefixo.endsWith("Entity"))
			return ENTITY_TO_MODEL_CONVERTER;
		else
			return MODEL_TO_ENTITY_CONVERTER;
	}
	String method(String prefix,String field) {
		return prefix+field.substring(0,1).toUpperCase() + field.substring(1,field.length());
	}
	public abstract Object newInstance() throws Exception;
	abstract Object converter(Object other) throws Exception;
}
