package digytal.java.exemplos.utils.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriterUtil {
	public static void write(byte [] bytes,String newFile) throws IOException {
		Path path = Paths.get(newFile);
        Files.write(path, bytes);
	}
	public static void write(File file,String newFile) throws IOException  {
		write(FileReaderUtil.bytes(file), newFile);
	}
	public static void write(String sourceFile,String newFile) throws IOException  {
		write(Files.readAllBytes(Paths.get(sourceFile)), newFile);
	}
}
