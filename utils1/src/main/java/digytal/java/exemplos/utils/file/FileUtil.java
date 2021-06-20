package digytal.java.exemplos.utils.file;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import digytal.java.exemplos.utils.text.TextUtil;

public class FileUtil {
	public static void main(String[] args) {
		File file=null;
		try {
			file = file("/docs/ppt/1/ppt.txt");
			System.out.println(file.exists());
			System.out.println(file.getAbsolutePath());
			
			file = file("D:/ROOT", "filha/external doc.txt");
			System.out.println(file.exists());
			System.out.println(file.getAbsolutePath());
			
			file = resource("parcelas/parcelas_layout_delimitado.txt");
			System.out.println(file.exists());
			System.out.println(file.getAbsolutePath());
			
			file = resource("parcelas","parcelas_layout_delimitado.txt");
			System.out.println(file.exists());
			System.out.println(file.getAbsolutePath());	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//https://mkyong.com/java/java-read-a-file-from-resources-folder/
	
	/*
	public static File fileResource(Object ... composition) throws Exception {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
    	String path = TextUtil.concat("\\", composition);
    	
    	URL resource = loader.getResource(path);
    	return new File(resource.toURI());
	}
	public static File file(String root, Object ... composition) {
		String path = TextUtil.concat("\\", composition);
		return new File(root,path);
	}
	
	*/
	/*
	public static File file(String filePath) {
		return new File(filePath);
	}
	public static InputStream inputStream(String filePath) throws FileNotFoundException {
		return new FileInputStream(filePath);	
	}
	public static InputStream inputStream(File file) throws FileNotFoundException {
		return new FileInputStream(file);	
	}
	*/
	public static File resource(Object ... composition) throws Exception {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
    	String path = TextUtil.concat("/", composition);
    	URL resource = loader.getResource(path);
    	return new File(resource.toURI());
	}
	public static Path path(String root, String ... composition) {
		return Paths.get(root, composition);
	}
	public static Path path(String filePath) {
		return Paths.get(filePath);
	}
	public static File file(String filePath) {
		return path(filePath).toFile();
	}
	public static File file(String root, String ... composition) {
		return path(root, composition).toFile();
	}
	
}
