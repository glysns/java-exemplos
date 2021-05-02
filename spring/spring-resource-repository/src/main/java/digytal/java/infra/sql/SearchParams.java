package digytal.java.infra.sql;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class SearchParams implements Map<String, Object>, Serializable {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> params = Collections.emptyMap();
	
	public static SearchParams of(Map<String, Object> map) {
		SearchParams instance = new SearchParams();
		instance.params = map;
		return instance;
	}
	
	@Override
	public void clear() {
		params.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return params.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return params.containsValue(value);
	}

	@Override
	public Set<Entry<String, Object>> entrySet() {
		return params.entrySet();
	}

	@Override
	public Object get(Object key) {
		return params.get(key);
	}

	@Override
	public boolean isEmpty() {
		return params.isEmpty();
	}

	@Override
	public Set<String> keySet() {
		return params.keySet();
	}

	@Override
	public Object put(String key, Object value) {
		return params.put(key, value);
	}

	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		params.putAll(m);
	}

	@Override
	public Object remove(Object key) {
		return params.remove(key);
	}

	@Override
	public int size() {
		return params.size();
	}

	@Override
	public Collection<Object> values() {
		return params.values();
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

}
