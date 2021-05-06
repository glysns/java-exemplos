package digytal.java.commons;

public class SimpleModel {
	public Object id;
	public Object uuid;
	public String text;
	
	public SimpleModel(Object id, Object uuid, String text) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.text = text;
	}
	public SimpleModel(Object id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
}
