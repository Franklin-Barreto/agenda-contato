package br.com.santander.agenda.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.santander.agenda.dto.ContactInput;
import br.com.santander.agenda.model.Contact;
import br.com.santander.agenda.service.ContactService;

@RestController
@RequestMapping("contact")
public class ContactController {

	private final ContactService contactService;
	private final Path root = Paths.get("uploads");
	
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody ContactInput contactInput){
		Contact contact = contactService.save(contactInput);
		return ResponseEntity.ok(contact);
	}
	
	@PutMapping("/{id}/photo")
	public ResponseEntity<?> uploadPhoto(@PathVariable Integer id, @RequestBody MultipartFile file){
		File fileUpload = new File( root.resolve(file.getOriginalFilename()).toUri());
		try {
			fileUpload.createNewFile();
			FileOutputStream fos = new FileOutputStream(fileUpload);
			fos.write(file.getBytes());
			fos.close();
			contactService.updatePhoto(id, file.getOriginalFilename());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok().build();
	}
}
