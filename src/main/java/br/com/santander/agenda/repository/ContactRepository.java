package br.com.santander.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.santander.agenda.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
