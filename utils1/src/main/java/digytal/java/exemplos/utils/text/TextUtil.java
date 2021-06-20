package digytal.java.exemplos.utils.text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class TextUtil {
	public static String concat(String delimiter, Object ... values) {
    	List strs = new ArrayList<>(Arrays.asList(values));
    	return concat(delimiter, strs);
    }
	//https://www.baeldung.com/java-strings-concatenation
	public static String concat(String delimiter,List values) {
    	StringJoiner sj = new StringJoiner(delimiter, "", "");
    	for(Object v: values) {
    		sj.add(Objects.toString(v,""));
    	}
    	return sj.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(TextUtil.concat(" ", "GLEYSON","SAMPAIO","OLIVEIRA"));
	}
   
}
