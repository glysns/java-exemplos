package digytal.java.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import digytal.java.model.Entity;
import digytal.java.repository.EntityRepository;

@Service
public class FileUploadService {
	@Value("${file.upload.folder}")
	private String fileUploadFolder;
	
	@Autowired
	private ObjectMapper mapper;
	
	public File saveOnDisk(MultipartFile webFile) throws Exception {
		Path folderPath = Paths.get(fileUploadFolder);
		Path newFilePath = folderPath.resolve(webFile.getOriginalFilename());
		Files.copy(webFile.getInputStream(), newFilePath, StandardCopyOption.REPLACE_EXISTING);
		return newFilePath.toFile();
	}
	public String convertJsonToDtoAndSaveOnDisk(String dto, MultipartFile webFile) throws Exception {
		//See digytal.java.config.Beans
		//mapper = new ObjectMapper();
		Entity entity = mapper.readValue(dto, Entity.class);
		File file = saveOnDisk(webFile);
		String result = "Dto String to Entity : " +entity + " -- File Path " + file.getAbsolutePath();
		System.out.println(result);
		return result;
		
	}
	
	@Autowired
	private EntityRepository repository;
	public Entity convertJsonToEntityPersistAndSaveOnDisk(String dto, MultipartFile webFile) throws Exception {
		//See digytal.java.config.Beans
		//mapper = new ObjectMapper();
		Entity entity = mapper.readValue(dto, Entity.class);
		File file = saveOnDisk(webFile);
		entity.setFilePath(file.getAbsolutePath());
		entity= repository.save(entity);
		return entity;
		
	}
}
