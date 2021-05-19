package digytal.java.resource;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import digytal.java.model.Entity;
import digytal.java.service.FileUploadService;

@RestController
@RequestMapping("file-upload")
public class FileUploadResource {
	@Autowired
	private FileUploadService service;
	@PostMapping(path = "/single-file", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public String uploadFile(@RequestPart("file") MultipartFile file) {
		try {
			File newFile= service.saveOnDisk(file);
			return newFile.getAbsolutePath();
		} catch (Exception e) {
			//TODO: Refectory Exception Handler
			e.printStackTrace();
			return null;
		}
	}
	//{"name":"GLEYSON", "number":1984}
	@PostMapping(path = "/dto-single-file", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public String uploadFile(@RequestPart("dto") String dto, @RequestPart("file") MultipartFile file) {
		try {
			return service.convertJsonToDtoAndSaveOnDisk(dto, file);
		} catch (Exception e) {
			//TODO: Refectory Exception Handler
			e.printStackTrace();
			return null;
		}
	}
	//{"name":"GLEYSON", "number":1984}
	@PostMapping(path = "/save-entity-single-file", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public Entity uploadFileSaveEntity(@RequestPart("dto") String dto, @RequestPart("file") MultipartFile file) {
		try {
			return service.convertJsonToEntityPersistAndSaveOnDisk(dto, file);
		} catch (Exception e) {
			//TODO: Refectory Exception Handler
			e.printStackTrace();
			return null;
		}
	}
}
