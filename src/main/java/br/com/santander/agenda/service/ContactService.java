package br.com.santander.agenda.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.santander.agenda.dto.ContactInput;
import br.com.santander.agenda.model.Contact;
import br.com.santander.agenda.repository.ContactRepository;

@Service
public class ContactService {

	private final ContactRepository contactRepository;

	public ContactService(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	public Contact save(ContactInput contactInput) {
		return contactRepository.save(contactInput.convert());
	}
	
	@Transactional
	public Contact updatePhoto(Integer id,String url) {
		Contact contact = this.contactRepository.findById(id).orElseThrow();
		contact.setPhotoUrl(url);
		return contact;
	}
}
